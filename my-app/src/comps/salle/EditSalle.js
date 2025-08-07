import React, { useEffect, useState } from "react";
import {useNavigate, useParams } from 'react-router-dom';
import SalleService from "../services/SalleService";
import MyTextInput from "../utils/FormikUtils";
import {Form, Formik} from "formik";
import * as Yup from "yup";

const EditSalle = () => {
    // Création d'une salle vide
    const initialFormState = {
        nom: '',
    };

    // etat
    const [salle, setSalle] = useState(initialFormState);
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();

    // Recupere l'id de la salle a éditer
    const { id } = useParams();

    // Charge la salle si id existe
    useEffect(() => {
        if (id !== 'new') {
            setLoading(true);
            SalleService.fetchSalle(id)
                .then(data => {
                    setSalle(data);
                    setLoading(false);
                });
        }
    }, [id, setSalle]);

    const doUpdate = async (values) => {
        await SalleService.updateSalle(values);
        // Reset form
        setSalle(initialFormState);
        // Move away
        navigate('/listSalle');
    }
    if (loading) {
        return <p>Loading...</p>;
    }

    const title = <h2>{salle.id ? 'Editer les information d\'une salle' : 'Enregistrer une salle de concert'}</h2>;
    // Render the form using bootstrap-react
    return (<div className="card">
            <div className="card-body">
                {title}
                <Formik
                    initialValues={salle}

                    validationSchema={Yup.object({
                        nom: Yup.string()
                            .max(15, 'Must be 15 characters or less')
                            .required('Required'),
                    })}


                    onSubmit={  (values, { setSubmitting }) => {
                        doUpdate(values);
                    }}
                >
                    <Form className="needs-validation" noValidate>
                        <MyTextInput
                            label="Nom"
                            name="nom"
                            type="text"
                            placeholder="Entrez le nom de la salle de concert"
                        />
                        <button className='btn btn-primary btn-sm' type="submit" style={{marginTop: "1%"}}>Envoyer</button>
                    </Form>
                </Formik>
            </div>
        </div>
    )
};
export default EditSalle;
import React, { useEffect, useState } from "react";
import {useNavigate, useParams } from 'react-router-dom';
import ArtisteService from "../services/ArtisteService";
import MyTextInput from "../utils/FormikUtils";
import {Form, Formik} from "formik";
import * as Yup from "yup";

const EditArtiste = () => {
    // Création d'un artiste vide
    const initialFormState = {
        nom: '',
    };

    // etat
    const [artiste, setArtiste] = useState(initialFormState);
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();

    // Recupere l'id de l'artiste a éditer
    const { id } = useParams();

    // Charge l'artiste si id existe
    useEffect(() => {
        if (id !== 'new') {
            setLoading(true);
            ArtisteService.fetchArtiste(id)
                .then(data => {
                    setArtiste(data);
                    setLoading(false);
                });
        }
    }, [id, setArtiste]);

    const doUpdate = async (values) => {
        await ArtisteService.updateArtiste(values);
        // Reset form
        setArtiste(initialFormState);
        // Move away
        navigate('/listArtiste');
    }
    if (loading) {
        return <p>Loading...</p>;
    }

    const title = <h2>{artiste.id ? 'Editer les information d\'un artiste' : 'Enregistrer un artiste'}</h2>;
    // Render the form using bootstrap-react
    return (<div className="card">
            <div className="card-body">
                {title}
                <Formik
                    initialValues={artiste}

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
                            placeholder="Entrez le nom de l'artiste"
                        />
                        <button className='btn btn-primary btn-sm' type="submit" style={{marginTop: "1%"}}>Envoyer</button>
                    </Form>
                </Formik>
            </div>
        </div>
    )
};
export default EditArtiste;
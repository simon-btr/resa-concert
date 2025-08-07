import React, { useEffect, useState } from "react";
import {useNavigate, useParams } from 'react-router-dom';
import ClientService from "../services/ClientService";
import MyTextInput from "../utils/FormikUtils";
import {Form, Formik} from "formik";
import * as Yup from "yup";

const EditSalle = () => {
    // Création d'un client vide
    const initialFormState = {
        nom: '',
        adresseDTO: {
            ville: '',
            rue: '',
        },
    };

    // etat
    const [client, setClient] = useState(initialFormState);
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();

    // Recupere l'id du client a éditer
    const { id } = useParams();

    // Charge le client si id existe
    useEffect(() => {
        if (id !== 'new') {
            setLoading(true);
            ClientService.fetchClient(id)
                .then(data => {
                    setClient(data);
                    setLoading(false);
                });
        }
    }, [id, setClient]);

    const doUpdate = async (values) => {
        await ClientService.updateClient(values);
        // Reset form
        setClient(initialFormState);
        // Move away
        navigate('/listClient');
    }
    if (loading) {
        return <p>Loading...</p>;
    }

    const title = <h2 style={{textAlign: "center", marginBottom: "15%"}}>{client.id ? 'Editer un client' : 'S\'inscrire en tant que client'}</h2>;
    // Render the form using bootstrap-react
    return (<div className="card" >
            <div className="card-body" style={{alignSelf: "center"}}>
                {title}
                <Formik
                    initialValues={client}

                    validationSchema={Yup.object({
                        nom: Yup.string()
                            .max(15, 'Must be 15 characters or less')
                            .required('Required'),
                        adresseDTO: Yup.object().shape({
                            ville: Yup.string().required('Required'),
                            rue: Yup.string().required('Required')
                        }),
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
                            placeholder="Entrez le nom du client"
                        />
                        <h6 style={{marginTop:"5%"}}>Adresse :</h6>
                        <MyTextInput
                            label="Ville"
                            name="adresseDTO.ville"
                            type="text"
                            placeholder="Entrez la ville"
                        />
                        <MyTextInput
                            label="Rue"
                            name="adresseDTO.rue"
                            type="text"
                            placeholder="Entrez la rue"
                        />
                        <button className='btn btn-primary btn-sm' type="submit" style={{marginTop: "5%"}}>Envoyer</button>
                    </Form>
                </Formik>
            </div>
        </div>
    )
};
export default EditSalle;
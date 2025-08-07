import React, { useEffect, useState } from "react";
import {useNavigate, useParams} from 'react-router-dom';
import ConcertService from "../services/ConcertService";
import MyTextInput from "../utils/FormikUtils";
import {Field, Form, Formik} from "formik";
import * as Yup from "yup";
import ArtisteService from "../services/ArtisteService";
import SalleService from "../services/SalleService";

const EditConcert = () => {
    // Création d'un concert vide
    const initialFormState = {
        titre: '',
        prix: '',
        date: '',
    };
    // etat
    const [concert, setConcert] = useState(initialFormState);
    const [artistes, setArtistes] = useState([]);
    const [salles, setSalles] = useState([]);
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();
    const myArrayOfArtistes = [];
    const myArrayOfSalles = [];
    // Recupere l'id du concert a éditer
    const { id } = useParams();


    // Charge le concert si id existe
    useEffect(() => {
        if (id !== 'new') {
            setLoading(true);
            ConcertService.fetchConcert(id)
                .then(data => {
                    setConcert(data);
                    setLoading(false);
                });
        }
    }, [id, setConcert]);

    // Charge tous les artistes
    useEffect(() => {
        setLoading(true);

        ArtisteService.fetchAllArtistes()
            .then(data => {
                setArtistes(data);
                setLoading(false);
            })

    }, []);

    // Charge tous les artistes
    useEffect(() => {
        setLoading(true);

        SalleService.fetchAllSalles()
            .then(data => {
                setSalles(data);
                setLoading(false);
            })

    }, []);


    const doUpdate = async (values) => {
        console.log(values)
        await ConcertService.updateConcert(values);
        // Reset form
        setConcert(initialFormState);
        // Move away
        navigate('/listConcert');
    }
    if (loading) {
        return <p>Loading...</p>;
    }

    const showSelectArtiste = () => {
        artistes.map((a) => myArrayOfArtistes.push(JSON.parse(JSON.stringify(a))));
        return(
            <Field as="select" name="artisteId">
                <option defaultValue  value="">(Choisissez un artiste)</option>
                {myArrayOfArtistes.map(artiste =>
                    <option key={artiste.id} value={artiste.id}>{artiste.nom}</option>
                )}
            </Field>
        )
    }

    const showSelectSalle = () => {
        salles.map((a) => myArrayOfSalles.push(JSON.parse(JSON.stringify(a))));
        return(
            <Field as="select" name="salleId">
                <option defaultValue  value="">(Choisissez une salle)</option>
                {myArrayOfSalles.map(salle =>
                    <option key={salle.id} value={salle.id}>{salle.nom}</option>
                )}
            </Field>
        )
    }

    const title = <h2>{concert.id ? 'Editer un concert' : 'Ajouter un concert'}</h2>;
    // Render the form using bootstrap-react
    return (<div className="card">
            <div className="card-body">
                {title}
                <Formik
                    initialValues={concert}

                    validationSchema={Yup.object({
                        titre: Yup.string()
                            .max(15, 'Must be 15 characters or less')
                            .required('Required'),
                        prix: Yup.number()
                            .min(5, 'Must be greater than 5')
                            .required('Required'),
                        date: Yup.date()
                            .required('Required'),
                        artisteId: Yup.string()
                            .required('Required'),
                        salleId: Yup.string()
                            .required('Required'),
                    })}


                    onSubmit={  (values, { setSubmitting }) => {
                        doUpdate(values);
                    }}
                >
                    <Form className="needs-validation" noValidate>
                        <MyTextInput
                            label="Titre"
                            name="titre"
                            type="text"
                            placeholder="Entrez le titre du concert"
                        />
                        <MyTextInput
                            label="Prix"
                            name="prix"
                            type="text"
                            placeholder="Entrez le prix"
                        />
                        <MyTextInput
                            label="Date"
                            name="date"
                            type="text"
                            placeholder="Entrez la date"
                        />
                        <label style={{marginTop: "1%"}}>Artiste</label>
                        <br/>
                        {showSelectArtiste()}
                        <br/>
                        <label style={{marginTop: "1%"}}>Salle</label>
                        <br/>
                        {showSelectSalle()}
                        <br/>
                        <button className='btn btn-primary btn-sm' type="submit" style={{marginTop: "1%"}}>Envoyer</button>
                    </Form>
                </Formik>
            </div>
        </div>
    )
};
export default EditConcert;
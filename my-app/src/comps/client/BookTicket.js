import React, { useEffect, useState } from "react";
import {useNavigate, useParams} from 'react-router-dom';
import {Field, Form, Formik} from "formik";
import * as Yup from "yup";
import ConcertService from "../services/ConcertService";
import ClientService from "../services/ClientService";

const BookTicket = () => {

    const { id } = useParams();
    const [concerts, setConcerts] = useState([]);
    const [loading, setLoading] = useState(false);
    const myArrayOfConcerts = [];
    const navigate = useNavigate();
    const initialFormState = {
        concertId: '',
    };

    useEffect(() => {
        setLoading(true);

        ConcertService.fetchAllConcerts()
            .then(data => {
                setConcerts(data);
                setLoading(false);
            })

    }, []);

    concerts.map((a) => myArrayOfConcerts.push(JSON.parse(JSON.stringify(a))));
    const showSelectConcert = () => {
        return(
            <Field as="select" name="concertId">
                <option defaultValue  value="">(Choisissez un concert)</option>
                {myArrayOfConcerts.map(concert =>
                    <option key={concert.id} value={concert.id}>{concert.titre}</option>
                )}
            </Field>
        )
    }

    const doUpdate = async (values) => {
        const res = {
            clientId: id,
            concertId: values.concertId,
        }
        await ClientService.bookTicket(res);
        // Move away
        navigate('/reservation');
    }
    if (loading) {
        return <p>Loading...</p>;
    }

    return (<div className="card" >
            <div className="card-body">
                <h2 className='card-title'>Réserver un billet pour un concert</h2>
                <Formik
                    initialValues={initialFormState}

                    validationSchema={Yup.object({
                        concertId: Yup.string()
                            .required('Required'),
                    })}

                    onSubmit={  (values, { setSubmitting }) => {
                        doUpdate(values);
                    }}
                >
                    <Form className="needs-validation" noValidate>
                        <h6>Concert :</h6>
                        {showSelectConcert()}
                        <br/>
                        <button className='btn btn-primary btn-sm' type="submit" style={{marginTop: "1%"}}>Envoyer</button>
                    </Form>
                </Formik>
            </div>
        </div>
    )
};

export default BookTicket;
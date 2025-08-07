import React, { useEffect, useState } from "react";
import {Link} from "react-router-dom";
import ConcertService from '../services/ConcertService';
import ArtisteService from "../services/ArtisteService";
import SalleService from "../services/SalleService";

// Component for listing concerts
function ShowConcerts() {

    const [currentConcert, setCurrentConcert] = useState();
    const [concerts, setConcerts] = useState([]);
    const [loading, setLoading] = useState(false);
    const [currentArtiste, setCurrentArtiste] = useState([]);
    const [currentSalle, setCurrentSalle] = useState([]);
    const myArray = [];

    const showDetail = () => {
        if (currentConcert == null) {
            return (
                <p></p>
            )
        } else {
            ArtisteService.fetchArtiste(currentConcert.artisteId)
                .then(data => {
                    setCurrentArtiste(data);
                })
            SalleService.fetchSalle(currentConcert.salleId)
                .then(data => {
                    setCurrentSalle(data);
                })
            return (
                <div className='card'>
                    <table className="table table-sm">
                        <thead>
                        <tr>
                            <th scope="col">Titre du concert</th>
                            <th scope="col">Prix</th>
                            <th scope="col">Date</th>
                            <th scope="col">Artiste</th>
                            <th scope="col">Salle de concert</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>{currentConcert.titre}</td>
                            <td>{currentConcert.prix} €</td>
                            <td>{currentConcert.date}</td>
                            <td>{currentArtiste.nom}</td>
                            <td>{currentSalle.nom}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            )
        }
    }

    const handleDetails = (concert) => {
        if (currentConcert == null) {
            setCurrentConcert(concert);
        } else {
            setCurrentConcert(null);
        }
    }

    const deleteById = async (id) => {
        console.log('delete called');
        ConcertService.deleteConcert(id)
            .then(() => {
                let updatedConcert = [...concerts].filter(i => i.id !== id);
                setConcerts(updatedConcert);
            });
        setCurrentConcert(null)
    }

    const showEmptyConcerts = (list) => {
        if (list.length === 0) {
            return (
                <p>Pas de concerts listés</p>
            )

        }
    }

    useEffect(() => {
        setLoading(true);

        ConcertService.fetchAllConcerts()
            .then(data => {
                setConcerts(data);
                setLoading(false);
            })
    }, []);

    if (loading) {
        return <p>Loading...</p>;
    }

    concerts.map((c) => myArray.push(JSON.parse(JSON.stringify(c))));

    return (
        <div className="card">
            <div className="card-body">
                <h2 className='card-title'>Liste des concerts</h2>
                {showEmptyConcerts(concerts)}
                {myArray.map(concert =>
                    <div className='card' key={concert.id} style={{marginBottom: "1%"}}>
                        <div className='card-body' key={concert.id}>
                            <h3 className='card-title' >{concert.titre}</h3>
                        </div>
                        <div className='card-footer'>
                            <button className='btn btn-primary btn-sm'
                                    type="button" onClick={() => handleDetails(concert)}>Détails</button>

                            <Link to={"/editConcert/" + concert.id} className="btn btn-primary btn-sm" style={{marginLeft: "1%"}}>Editer</Link>

                            <button className='btn btn-danger btn-sm'
                                    type="button" onClick={() => deleteById(concert.id)} style={{marginLeft: "1%"}}>Supprimer</button>
                        </div>
                    </div>
                )}
                <br/>
                {showDetail()}
            </div>
        </div>
    );
}

export default ShowConcerts;
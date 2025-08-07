import React, { useEffect, useState } from "react";
import {Link} from "react-router-dom";
import SalleService from "../services/SalleService";

function ShowSalles() {

    const [salles, setSalles] = useState([]);
    const [loading, setLoading] = useState(false);
    const myArray = [];

    const deleteById = async (id) => {
        console.log('delete called');
        SalleService.deleteSalle(id)
            .then(() => {
                let updatedSalle = [...salles].filter(i => i.id !== id);
                setSalles(updatedSalle);
            });
    }

    const showEmptySalles = (list) => {
        if (list.length === 0) {
            return (
                <p>Pas de salles enregistrées</p>
            )

        }
    }

    useEffect(() => {
        setLoading(true);

        SalleService.fetchAllSalles()
            .then(data => {
                setSalles(data);
                setLoading(false);
            })
    }, []);

    if (loading) {
        return <p>Loading...</p>;
    }

    salles.map((a) => myArray.push(JSON.parse(JSON.stringify(a))));

    return (
        <div className="card">
            <div className="card-body">
                <h2 className='card-title'>Liste des salles de concert</h2>
                {showEmptySalles(salles)}
                {myArray.map(salle =>
                    <div className='card' key={salle.id} style={{marginBottom: "1%"}}>
                        <div className='card-body' key={salle.id}>
                            <h3 className='card-title' >{salle.nom}</h3>
                        </div>
                        <div className='card-footer'>
                            <Link to={"/editSalle/" + salle.id} className="btn btn-primary btn-sm">Editer les informations</Link>

                            <button className='btn btn-danger btn-sm'
                                    type="button" onClick={() => deleteById(salle.id)} style={{marginLeft: "1%"}}>Supprimer</button>
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
}

export default ShowSalles;
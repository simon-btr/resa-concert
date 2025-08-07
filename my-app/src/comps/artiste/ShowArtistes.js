import React, { useEffect, useState } from "react";
import {Link} from "react-router-dom";
import ArtisteService from "../services/ArtisteService";

function ShowArtistes() {

    const [artistes, setArtistes] = useState([]);
    const [loading, setLoading] = useState(false);
    const myArray = [];

    const deleteById = async (id) => {
        console.log('delete called');
        ArtisteService.deleteArtiste(id)
            .then(() => {
                let updatedArtiste = [...artistes].filter(i => i.id !== id);
                setArtistes(updatedArtiste);
            });
    }

    const showEmptyArtistes = (list) => {
        if (list.length === 0) {
            return (
                <p>Pas d'artistes enregistrés</p>
            )

        }
    }

    useEffect(() => {
        setLoading(true);

        ArtisteService.fetchAllArtistes()
            .then(data => {
                setArtistes(data);
                setLoading(false);
            })
    }, []);

    if (loading) {
        return <p>Loading...</p>;
    }

    artistes.map((a) => myArray.push(JSON.parse(JSON.stringify(a))));

    return (
        <div className="card">
            <div className="card-body">
                <h2 className='card-title'>Liste des artistes</h2>
                {showEmptyArtistes(artistes)}
                {myArray.map(artiste =>
                    <div className='card' key={artiste.id} style={{marginBottom: "1%"}}>
                        <div className='card-body' key={artiste.id}>
                            <h3 className='card-title' >{artiste.nom}</h3>
                        </div>
                        <div className='card-footer'>
                            <Link to={"/editArtiste/" + artiste.id} className="btn btn-primary btn-sm">Editer les informations</Link>

                            <button className='btn btn-danger btn-sm'
                                    type="button" onClick={() => deleteById(artiste.id)} style={{marginLeft: "1%"}}>Supprimer</button>
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
}

export default ShowArtistes;
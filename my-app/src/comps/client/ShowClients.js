import React, { useEffect, useState } from "react";
import {Link} from "react-router-dom";
import ClientService from "../services/ClientService";

function ShowClients() {

    const [clients, setClients] = useState([]);
    const [loading, setLoading] = useState(false);
    const myArray = [];

    const deleteById = async (id) => {
        console.log('delete called');
        ClientService.deleteClient(id)
            .then(() => {
                let updatedClient = [...clients].filter(i => i.id !== id);
                setClients(updatedClient);
            });
    }

    const showEmptyClients = (list) => {
        if (list.length === 0) {
            return (
                <p>Pas de clients enregistrés</p>
            )

        }
    }

    useEffect(() => {
        setLoading(true);

        ClientService.fetchAllClients()
            .then(data => {
                setClients(data);
                setLoading(false);
            })
    }, []);

    if (loading) {
        return <p>Loading...</p>;
    }

    clients.map((a) => myArray.push(JSON.parse(JSON.stringify(a))));

    return (
        <div className="card">
            <div className="card-body">
                <h2 className='card-title'>Liste des clients</h2>
                {showEmptyClients(clients)}
                {myArray.map(client =>
                    <div className='card' key={client.id} style={{marginBottom: "1%"}}>
                        <div className='card-body' key={client.id}>
                            <h3 className='card-title'>{client.nom}</h3>
                            <h6>Adresse :</h6>
                            <p>Ville : {client.adresseDTO.ville}<br/>Rue : {client.adresseDTO.rue}</p>
                        </div>
                        <div className='card-footer'>
                            <Link to={"/editClient/" + client.id} className="btn btn-primary btn-sm">Editer les informations</Link>

                            <Link to={"/bookTicket/" + client.id} className="btn btn-primary btn-sm" style={{marginLeft: "1%"}}>Réserver un billet</Link>

                            <button className='btn btn-danger btn-sm'
                                    type="button" onClick={() => deleteById(client.id)} style={{marginLeft: "1%"}}>Supprimer</button>
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
}

export default ShowClients;
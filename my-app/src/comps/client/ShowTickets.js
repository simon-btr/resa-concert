import React, { useEffect, useState } from "react";
import ClientService from "../services/ClientService";

function ShowTickets() {
    const [clients, setClients] = useState([]);

    useEffect(() => {

        ClientService.fetchAllClients()
            .then(data => {
                setClients(data);
            })
    }, []);

    const showDetails = (billet) => {
        const date = billet.dateDachat;
        const titre = billet.concertTitre;
        const artiste = billet.concertArtiste;
        const prix = billet.concertPrix;
        const dateConcert = billet.concertDate;
        const concertSalle = billet.concertSalle;
        return (
            <div className='card' key={billet.id}style={{marginBottom: "1%"}}>
                <table className="table table-sm">
                    <thead>
                    <tr>
                        <th scope="col">Titre du concert</th>
                        <th scope="col">Date d'achat du billet</th>
                        <th scope="col">Artiste</th>
                        <th scope="col">Prix</th>
                        <th scope="col">Date du concert</th>
                        <th scope="col">Salle de concert</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>{titre}</td>
                        <td>{date}</td>
                        <td>{artiste}</td>
                        <td>{prix}</td>
                        <td>{dateConcert}</td>
                        <td>{concertSalle}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    }

    const showEmpty = (list) => {
        if (list.length === 0) {
            return (
                <p>Aucune réservation</p>
            )
        }
    }

    return (
        <div className="card">
            <div className="card-body">
                <h2 className='card-title'>Liste des réservations des clients</h2>
                {clients.map(c =>
                    <div key={c.id}>
                        <h4 style={{marginTop: "2%"}}>CLIENT : {c.nom}</h4>
                        {showEmpty(c.billetDTOList)}
                        <div>{c.billetDTOList.map(b => showDetails(b))}</div>
                    </div>
                )}
            </div>
        </div>
    )
}

export default ShowTickets;
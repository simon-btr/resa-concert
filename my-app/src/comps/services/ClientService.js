const SERVER_URL = "http://localhost:8080";

class ClientService {

    async fetchAllClients() {
        return fetch(SERVER_URL + '/client')
            .then(response => response.json());
    }

    async fetchClient( id ) {
        return fetch(SERVER_URL + '/client/' + id)
            .then(response => response.json());
    }

    async updateClient( client ) {
        return fetch( SERVER_URL + '/client' + (client.id ? '/' + client.id : ''), {
            method: (client.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(client)
        });
    }

    async deleteClient(id) {
        return await fetch(SERVER_URL + '/client/' + id, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    async bookTicket( reservation ) {
        return fetch( SERVER_URL + '/client/' + reservation.clientId + '/book/concert/' + reservation.concertId, {
            method: 'PUT'
        });
    }
}
export default new ClientService();
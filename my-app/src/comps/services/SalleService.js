const SERVER_URL = "http://localhost:8080";

class SalleService {

    async fetchAllSalles() {
        return fetch(SERVER_URL + '/salle')
            .then(response => response.json());
    }

    async fetchSalle( id ) {
        return fetch(SERVER_URL + '/salle/' + id)
            .then(response => response.json());
    }

    async updateSalle( salle ) {
        return fetch( SERVER_URL + '/salle' + (salle.id ? '/' + salle.id : ''), {
            method: (salle.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(salle)
        });
    }

    async deleteSalle (id) {
        return await fetch(SERVER_URL + '/salle/' + id, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }
}
export default new SalleService();
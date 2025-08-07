const SERVER_URL = "http://localhost:8080";

class ConcertService {

    async fetchAllConcerts() {
        return fetch(SERVER_URL + '/concert')
            .then(response => response.json());
    }

    async fetchConcert( id ) {
        return fetch(SERVER_URL + '/concert/' + id)
            .then(response => response.json());
    }

    async updateConcert( concert ) {
        return fetch( SERVER_URL + '/concert' + (concert.id ? '/' + concert.id : ''), {
            method: (concert.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(concert)
        });
    }

    async deleteConcert (id) {
        return await fetch(SERVER_URL + '/concert/' + id, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }
}
export default new ConcertService();
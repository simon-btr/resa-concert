const SERVER_URL = "http://localhost:8080";

class ArtisteService {

    async fetchAllArtistes() {
        return fetch(SERVER_URL + '/artiste')
            .then(response => response.json());
    }

    async fetchArtiste( id ) {
        return fetch(SERVER_URL + '/artiste/' + id)
            .then(response => response.json());
    }

    async updateArtiste( artiste ) {
        return fetch( SERVER_URL + '/artiste' + (artiste.id ? '/' + artiste.id : ''), {
            method: (artiste.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(artiste)
        });
    }

    async deleteArtiste(id) {
        return await fetch(SERVER_URL + '/artiste/' + id, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }
}
export default new ArtisteService();
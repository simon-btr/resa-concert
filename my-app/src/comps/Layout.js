import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import {NavDropdown} from "react-bootstrap";

// Layout component
const Layout = () => {
    return (
        <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark" className="p-3">
            <Container>
                <Navbar.Brand>Résa-Concert</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                <Nav className="me-auto">
                    <Nav.Link className="text-decoration-none text-white" href="/">
                        Home
                    </Nav.Link>

                    <NavDropdown title="Concert" id="navbarConcertDropdown">
                        <NavDropdown.Item href="/listConcert">Liste des concerts</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="/editConcert/new">Créer un concert</NavDropdown.Item>
                    </NavDropdown>

                    <NavDropdown title="Artiste" id="navbarArtisteDropdown">
                        <NavDropdown.Item href="/listArtiste">Liste des artistes</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="/editArtiste/new">Enregistrer un artiste</NavDropdown.Item>
                    </NavDropdown>

                    <NavDropdown title="Salle" id="navbarSalleDropdown">
                        <NavDropdown.Item href="/listSalle">Liste des salles de concert</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="/editSalle/new">Enregistrer une salle de concert</NavDropdown.Item>
                    </NavDropdown>

                    <NavDropdown title="Client" id="navbarSalleDropdown">
                        <NavDropdown.Item href="/listClient">Liste des clients</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="/reservation">Réservations</NavDropdown.Item>
                    </NavDropdown>
                </Nav>
                <Nav className="gap-2">
                    <Nav.Link className="btn btn-primary" href="/editClient/new">
                    S'inscrire
                    </Nav.Link>
                </Nav>
                </Navbar.Collapse>
            </Container>
            </Navbar>
    )
};
export default Layout;
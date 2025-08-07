import '../style/App.css';

import NoPage from './NoPage';
import Layout from './Layout';
import Home from './Home';
import ShowConcerts from './concert/ShowConcerts';
import EditConcert from './concert/EditConcert';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ShowArtistes from "./artiste/ShowArtistes";
import EditArtiste from "./artiste/EditArtiste";
import ShowSalles from "./salle/ShowSalles";
import EditSalle from "./salle/EditSalle";
import EditClient from "./client/EditClient";
import ShowClients from "./client/ShowClients";
import BookTicket from "./client/BookTicket";
import ShowTickets from "./client/ShowTickets";

// Main component
function App() {
  
  return (
    <>
      <BrowserRouter>
        <Layout />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/listConcert" element={<ShowConcerts />} />
          <Route path="/editConcert/:id" element={<EditConcert />} />
          <Route path="/listArtiste" element={<ShowArtistes />} />
          <Route path="/editArtiste/:id" element={<EditArtiste />} />
          <Route path="/listSalle" element={<ShowSalles />} />
          <Route path="/editSalle/:id" element={<EditSalle />} />
          <Route path="/listClient/" element={<ShowClients />} />
          <Route path="/editClient/:id" element={<EditClient />} />
          <Route path="/bookTicket/:id" element={<BookTicket />} />
          <Route path="/reservation" element={<ShowTickets />} />
          <Route path="*" element={<NoPage />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

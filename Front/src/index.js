import React from 'react'
import { createRoot } from 'react-dom/client';
import { Link, Routes, Route, BrowserRouter as Router, Navigate } from 'react-router-dom';
import { Navbar, Nav, Container, Button } from 'react-bootstrap';
import Home from './components/Home';
import Login from './components/authorization/Login';
import { logout } from './services/auth';
import Movies from './components/movies/Movies';
import AddMovie from './components/movies/AddMovie';
import EditMovie from './components/movies/EditMovie';
import Projections from './components/projections/Projections';
import Registration from './components/registration/Registration';
import Users from './components/users/Users';
import Tickets from './components/tickets/Tickets';
import Movie from './components/movies/Movie';


class App extends React.Component {

  render() {
    const jwt = window.localStorage['jwt'];

    if (jwt) {
      return (
        <>
          <Router>
            <Navbar  className='nav-bk3' >
              <Navbar.Brand as={Link} to="/home">
                {/* <img
              src="/logo.png"
              width="40"
              height="40"
              className="d-inline-block align-top"
              alt="React Bootstrap logo"
            /> */}
                <p3>Pocetna</p3>
              </Navbar.Brand>
              <Nav variant="pills" defaultActiveKey={"/home"}>
                <Nav.Link as={Link} to="/movies">
                  <p2>Filmovi</p2>
                </Nav.Link>
                <Nav.Link as={Link} to="/projections">
                  <p2>Projekcije</p2>
                </Nav.Link>
                <Nav.Link as={Link} to="users/registrations">
                  <p2>Registracija</p2>
                </Nav.Link>
                {window.localStorage['role'] == 'ROLE_ADMIN' ?
                  <Nav.Link as={Link} to="/tickets">
                    <p2>Karte</p2>
                  </Nav.Link>
                  : null}
                {window.localStorage['role'] == 'ROLE_ADMIN' ?
                  <Nav.Link as={Link} to="/users">
                    <p2>Korisnici</p2>
                  </Nav.Link>
                  : null}
                <Button variant="info" onClick={() => logout()}><p2>Logout</p2></Button>
              </Nav>
            </Navbar>
            <Container style={{ paddingTop: "10px" }}>
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Navigate replace to='/' />} />
                <Route path="/movies" element={<Movies />} />
                <Route path="/movies/add" element={<AddMovie />} />
                <Route path="/movies/edit/:id" element={<EditMovie />} />
                <Route path="/movies/:id" element={<Movie />} />
                <Route path="/movies/add" element={<AddMovie />} />
                <Route path="/projections" element={<Projections />} />
                {window.localStorage['role'] == 'ROLE_ADMIN' ?
                <Route path="/tickets" element={<Tickets />} /> : null}
                <Route path="/users/registrations" element={<Registration />} />
                {window.localStorage['role'] == 'ROLE_ADMIN' ?
                  <Route path="/users" element={<Users />} /> : null}
                <Route path='*' element={<Navigate replace to='/' />} />
              </Routes>
            </Container>
          </Router>
        </>
      );
    } else {
      return (
        <>
          <Router>
            <Navbar className='nav-bk3'>
              <Navbar.Brand as={Link} to="/">
                Home
              </Navbar.Brand>
              <Nav variant="pills" defaultActiveKey={"/home"}>
                <Nav.Link as={Link} to="/movies">
                  Filmovi
                </Nav.Link>
                <Nav.Link as={Link} to="/projections">
                  Projekcije
                </Nav.Link>
                <Nav.Link as={Link} to="users/registrations">
                  Registracija
                </Nav.Link>
                {window.localStorage['role'] == 'ROLE_ADMIN' ?
                  <Nav.Link as={Link} to="/tickets">
                    <p2>Karte</p2>
                  </Nav.Link>
                  : null}
                {window.localStorage['role'] == 'ROLE_ADMIN' ?
                  <Nav.Link as={Link} to="/users">
                    Korisnici
                  </Nav.Link>
                  : null}
                <Nav.Link as={Link} to="/login">
                  Login
                </Nav.Link>
              </Nav>
            </Navbar>
            <Container style={{ paddingTop: "10px" }}>
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/movies" element={<Movies />} />
                <Route path="/movies/:id" element={<Movie />} />
                <Route path="/projections" element={<Projections />} />
                {window.localStorage['role'] == 'ROLE_ADMIN' ?
                <Route path="/tickets" element={<Tickets />} /> : null}
                <Route path="/users/registrations" element={<Registration />} />
                {window.localStorage['role'] == 'ROLE_ADMIN' ?
                  <Route path="/users" element={<Users />} /> : null}
                <Route path='*' element={<Navigate replace to='/' />} />
              </Routes>
            </Container>
          </Router>
        </>
      );
    }
  }
};

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
  <App />,
);
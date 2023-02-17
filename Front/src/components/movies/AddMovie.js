import React from 'react';
import { Row, Col, Form, Button } from "react-bootstrap";
import Axios from '../../apis/Axios';
import { withParams, withNavigation } from '../../routeconf';

class AddMovie extends React.Component {

    constructor(props) {
        super(props)

        let movie = {
            name: "",
            director: "",
            actors: "",
            genres: "",
            duration: 0,
            distributor: "",
            countryOfOrigin: "",
            yearOfProduction: 0,
            description: ""
        }

        this.state = { movie: movie }
    }

    async create(e) {
        e.preventDefault()

        try {
            let movie = this.state.movie
            let movieDTO = {
                name: movie.name,
                director: movie.director,
                actors: movie.actors,
                genres: movie.genres,
                duration: movie.duration,
                distributor: movie.distributor,
                countryOfOrigin: movie.countryOfOrigin,
                yearOfProduction: movie.yearOfProduction,
                description: movie.description,
            }

            let response = await Axios.post("/movies", movieDTO)
            this.props.navigate("/movies")
        } catch (error) {
            alert("Nije dodat novi film!")
        }
    }

    valueInputChanged(e) {
        let input = e.target;

        let name = input.name;
        let value = input.value;

        let movie = this.state.movie;
        movie[name] = value;

        this.setState({ movie: movie });
    }

    render() {
        return (
            <>
                <Row>
                    <Col></Col>
                    <Col xs="12" sm="10" md="8">
                        <h1>Dodaj film</h1>

                        <Form>
                            <Form.Group>
                                <Form.Label>Naziv filma: </Form.Label>
                                <Form.Control
                                   size="sm" id="name" name="name" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Direktor: </Form.Label>
                                <Form.Control
                                   size="sm" id="director" name="director" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Glumci: </Form.Label>
                                <Form.Control
                                   size="sm" id="actors" name="actors" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Zanrovi: </Form.Label>
                                <Form.Control
                                   size="sm" id="genres" name="genres" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Trajanje: </Form.Label>
                                <Form.Control type="number" id="duration" name="duration" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Distributer: </Form.Label>
                                <Form.Control
                                   size="sm" id="distributor" name="distributor" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Zemlja porekla: </Form.Label>
                                <Form.Control
                                   size="sm" id="countryOfOrigin" name="countryOfOrigin" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Godina proizvodnje: </Form.Label>
                                <Form.Control size="sm" type="number" id="yearOfProduction" name="yearOfProduction" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Opis: </Form.Label>
                                <Form.Control
                                   size="sm" id="description" name="description" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Button size="sm" variant="outline-success" onClick={(event) => { this.create(event); }}>Dodaj</Button>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>
            </>
        )
    }

}

export default withNavigation(AddMovie);
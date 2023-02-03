import React from "react";
import { Row, Col, Button, Table, Form } from 'react-bootstrap'
import Axios from "../../apis/Axios";
import { withParams, withNavigation } from '../../routeconf';
import './../../index.css';


class Projections extends React.Component {

    constructor(props) {
        super(props)

        this.pageNo = 0;
        this.totalPages = 0;

        const search = {
            movieId: "",
            dateTimeOfDisplayFrom: "",
            dateTimeOfDisplayTo: "",
            typeOfProjectionId: 0,
            hallId: 0,
            ticketPriceFrom: 0,
            ticketPriceTo: 10000
        }

        this.state = {
            movies: [],
            projections: [],
            halls: [],
            typesOfProjection: [],
            // projectionId: 0,
            search: search,
            showing: false,
        }
    }

    componentDidMount() {
        this.getMovies()
        this.getProjections(0)
        this.getHalls()
        this.getTypesOfProjection()
    }

    async getProjections(newPageNo) {

        let config = {
            params: {
                movieId: this.state.search.movieId,
                dateTimeOfDisplayFrom: this.state.search.dateTimeOfDisplayFrom,
                dateTimeOfDisplayTo: this.state.search.dateTimeOfDisplayTo,
                typeOfProjectionId: this.state.search.typeOfProjectionId,
                hallId: this.state.search.hallId,
                ticketPriceFrom: this.state.search.ticketPriceFrom,
                ticketPriceTo: this.state.search.ticketPriceTo,
                pageNo: newPageNo
            }
        }

        try {
            let result = await Axios.get("/projections", config)
            this.pageNo = newPageNo
            this.totalPages = result.headers["total-pages"]
            this.setState({
                projections: result.data
            })
        } catch (error) {
            console.log(error)

        }
    }

    getMovies() {
        Axios.get("/movies")
            .then((res) => {
                this.setState({ movies: res.data })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    getHalls() {
        Axios.get("/halls")
            .then((res) => {
                this.setState({ halls: res.data })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    getTypesOfProjection() {
        Axios.get("/typesOfProjection")
            .then((res) => {
                this.setState({ typesOfProjection: res.data })
            })
            .catch((error) => {
                console.log(error)
            })
    }


    movieSelectionChanged(e) {
        let movieId = e.target.value
        let movie = this.state.movies.find((movie) => movie.id == movieId)

        this.state.movieId = movie.id
    }

    hallSelectionChanged(e) {
        let hallId = e.target.value
        let hall = this.state.halls.find((hall) => hall.id == hallId)

        this.state.hallId = hall.id
    }

    typeOfProjectionSelectionChanged(e) {
        let typeOfProjectionId = e.target.value
        let typeOfProjection = this.state.typesOfProjection.find((typeOfProjection) => typeOfProjection.id == typeOfProjectionId)

        this.state.typeOfProjectionId = typeOfProjection.id
    }

    goToAdd() {
        this.props.navigate("/projections/add")
    }

    goToMovie(id){
        this.props.navigate("/movies/" + id)
    }

    onInputChange(event) {
        const name = event.target.name;
        const value = event.target.value

        let search = this.state.search;
        search[name] = value;

        this.setState({ search })
    }

    renderSearchForm() {
        return (
            <>
                <Form style={{ width: "100%" }} >
                    <Row ><Col xs="auto">
                        <Form.Group >
                            <Form.Label>Film</Form.Label>
                            <Form.Control
                                placeholder="Naziv filma"
                                size="sm"
                                name="name"
                                as="input"
                                type="text"
                                onChange={(e) => this.onInputChange(e)}>
                            </Form.Control>
                        </Form.Group>
                    </Col>
                        <Col xs="auto">
                            <Form.Group >
                                <Form.Label>Datum projekcije od:</Form.Label>
                                <Form.Control
                                    placeholder="Datum od"
                                    size="sm"
                                    name="dateTimeOfDisplayFrom"
                                    as="input"
                                    type="text"
                                    onChange={(e) => this.onInputChange(e)}>
                                </Form.Control>
                            </Form.Group>
                        </Col>
                        <Col xs="auto">
                            <Form.Group >
                                <Form.Label>Datum projekcije do:</Form.Label>
                                <Form.Control
                                    placeholder="Datum do"
                                    size="sm"
                                    name="dateTimeOfDisplayTo"
                                    as="input"
                                    type="text"
                                    onChange={(e) => this.onInputChange(e)}>
                                </Form.Control>
                            </Form.Group>
                        </Col>
                        <Col xs="auto">
                            <Form.Group>
                                <Form.Label>Tip projekcije</Form.Label>
                                <Form.Select
                                    defaultValue="Izaberite..."
                                    size="sm"
                                    name="typeOfProjectionId"
                                    onChange={(e) => this.onInputChange(e)}>
                                    <option>Izaberite...</option>
                                    {this.state.typesOfProjection.map((typeOfProjection) => {
                                        return (
                                            <option key={typeOfProjection.id} value={typeOfProjection.id}>{typeOfProjection.name}</option>
                                        );
                                    })}
                                </Form.Select>
                            </Form.Group>
                        </Col>
                        <Col xs="auto">
                            <Form.Group>
                                <Form.Label>Sala</Form.Label>
                                <Form.Select
                                    defaultValue="Izaberite..."
                                    size="sm"
                                    name="hallId"
                                    onChange={(e) => this.onInputChange(e)}>
                                    <option>Izaberite...</option>
                                    {this.state.halls.map((hall) => {
                                        return (
                                            <option key={hall.id} value={hall.id}>{hall.name}</option>
                                        );
                                    })}
                                </Form.Select>
                            </Form.Group>
                        </Col>
                    </Row>

                    <Row>
                        <Col xs="auto">
                            <Form.Group >
                                <Form.Label>Cena karte od:</Form.Label>
                                <Form.Control
                                    placeholder="Cena od:"
                                    size="sm"
                                    name="ticketPriceFrom"
                                    as="input"
                                    type="number"
                                    onChange={(e) => this.onInputChange(e)}>
                                </Form.Control>
                            </Form.Group>
                        </Col>
                        <Col xs="auto">
                            <Form.Group >
                                <Form.Label>Cena karte do:</Form.Label>
                                <Form.Control
                                    placeholder="Cena do:"
                                    size="sm"
                                    name="ticketPriceTo"
                                    as="input"
                                    type="number"
                                    onChange={(e) => this.onInputChange(e)}>
                                </Form.Control>
                            </Form.Group>
                        </Col>
                        <Col>
                        </Col>
                        <Col>
                        </Col>
                        <Col>
                            <br />
                            <Button size="sm" variant="outline-secondary" onClick={() => this.getProjections()}>Search</Button>
                        </Col>
                    </Row>
                </Form>
                <Row>
                </Row>
            </>
        )
    }

    render() {
        return (
            <Col>
                <div>
                    <Row hidden={this.state.showing}>
                        {this.renderSearchForm()}
                    </Row>
                </div>
                <br />


                <Row ><Col>

                </Col></Row>
                <Row><Col>

                    <Table className="table123" style={{ marginTop: 10 }} size="xl" >
                        <thead className="custom-header">
                            <tr>
                                <th><p2>Film</p2></th>
                                <th><p2>Datum projekcije</p2></th>
                                <th><p2>Tip projekcije</p2></th>
                                <th><p2>Cena karte</p2></th>
                                <th><p2>Sala</p2></th>
                                <th></th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.projections.map((projection) => {
                                return (
                                    <tr key={projection.id}>
                                        <Button variant="default" onClick={() => this.goToMovie(projection.movie.id)}>{projection.movie.name}</Button>
                                        <td>{projection.dateTimeOfDisplay}</td>
                                        <td>{projection.typeOfProjection.name}</td>
                                        <td>{projection.ticketPrice}</td>
                                        <td>{projection.hall.name}</td>

                                        {window.localStorage['role'] == 'ROLE_ADMIN' ?
                                            <td><Button size="sm" variant="outline-danger" onClick={() => this.goToDelete(projection.id)}>Obrisi projekciju</Button></td> : null}
                                        <Row><Col>
                                            {window.localStorage['role'] == 'ROLE_ADMIN' ?
                                                <Button size="sm" variant="outline-success" onClick={() => this.goToAdd()}>Dodaj novu projekciju</Button> : null}
                                        </Col></Row>

                                    </tr>
                                );
                            })}
                        </tbody>
                    </Table>

                    <Button size="sm" variant="outline-primary" disabled={this.pageNo === 0} onClick={() => this.getProjections(this.pageNo - 1)} className="mr-3">Prev</Button>
                    <Button size="sm" variant="outline-primary" disabled={this.pageNo == this.totalPages - 1} onClick={() => this.getProjections(this.pageNo + 1)} className="mr-3">Next</Button>
                </Col></Row>
            </Col>
        )
    }
}

export default withNavigation(withParams(Projections))
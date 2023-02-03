import React from "react";
import { Row, Col, Button, Table, Form } from 'react-bootstrap'
import Axios from "../../apis/Axios";
import { withParams, withNavigation } from '../../routeconf';
import './../../index.css';


class Movies extends React.Component {

    constructor(props) {
        super(props)

        this.pageNo = 0;
        this.totalPages = 0;

        const search = {
            name: "",
            genres: "",
            durationFrom: 0,
            durationTo: 500,
            distributor: "",
            countryOfOrigin: "",
            yearOfProductionFrom: 2010,
            yearOfProductionTo: 2024,
            projectionId: 0
        }

        this.state = {
            movies: [],
            projections: [],
            // projectionId: 0,
            search: search,
            showing: false,
        }

    }

    componentDidMount() {
        this.getMovies(0)
        this.getProjections()
    }

    async getMovies(newPageNo) {

        let config = {
            params: {
                name: this.state.search.name,
                genres: this.state.search.genres,
                durationFrom: this.state.search.durationFrom,
                durationTo: this.state.search.durationTo,
                countryOfOrigin: this.state.search.countryOfOrigin,
                yearOfProductionFrom: this.state.search.yearOfProductionFrom,
                yearOfProductionTo: this.state.search.yearOfProductionTo,
                projectionId: this.state.search.projectionId,
                pageNo: newPageNo
            }
        }

        try {
            let result = await Axios.get("/movies", config)
            this.pageNo = newPageNo
            this.totalPages = result.headers["total-pages"]
            this.setState({
                movies: result.data
            })
        } catch (error) {
            console.log(error)

        }
    }

    getProjections() {
        Axios.get("/projections")
            .then((res) => {
                this.setState({ projections: res.data })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    projectionSelectionChanged(e) {
        let projectionId = e.target.value
        let projection = this.state.projections.find((projection) => projection.id == projectionId)

        this.state.projectionId = projection.id
    }

    goToAdd() {
        this.props.navigate("/movies/add")
    }

    goToEdit(id) {
        this.props.navigate("/movies/edit/" + id)
    }

    goToMovie(id){
        this.props.navigate("/movies/" + id)
    }

    deleteFromState(movieId) {
        var movies = this.state.movies
        movies.forEach((element, index) => {
            if (element.id === movieId) {
                movies.splice(index, 1)
                this.setState({ movies: movies })
            }
        })
    }

    goToDelete(movieId) {
        Axios.delete("/movies/" + movieId)
            .then(res => {
                console.log(res)
                this.deleteFromState(movieId)
                window.location.reload()
            })
            .catch(error => {
                console.log(error)
                window.location.reload()
            })
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
                            <Form.Label>Naziv</Form.Label>
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
                                <Form.Label>Zanrovi</Form.Label>
                                <Form.Control
                                    placeholder="Zanr"
                                    size="sm"
                                    name="genres"
                                    as="input"
                                    type="text"
                                    onChange={(e) => this.onInputChange(e)}>
                                </Form.Control>
                            </Form.Group>
                        </Col>
                        <Col xs="auto">
                            <Form.Group >
                                <Form.Label>Trajanje od:</Form.Label>
                                <Form.Control
                                    placeholder="Trajanje od"
                                    size="sm"
                                    name="durationFrom"
                                    as="input"
                                    type="number"
                                    onChange={(e) => this.onInputChange(e)}>
                                </Form.Control>
                            </Form.Group>
                        </Col>
                        <Col xs="auto">
                            <Form.Group >
                                <Form.Label>Trajanje do:</Form.Label>
                                <Form.Control
                                    placeholder="Trajanje do"
                                    size="sm"
                                    name="durationTo"
                                    as="input"
                                    type="number"
                                    onChange={(e) => this.onInputChange(e)}>
                                </Form.Control>
                            </Form.Group>
                        </Col>
                        <Col xs="auto">
                            <Form.Group >
                                <Form.Label>Distributer</Form.Label>
                                <Form.Control
                                    placeholder="Distributer"
                                    size="sm"
                                    name="distributor"
                                    as="input"
                                    type="text"
                                    onChange={(e) => this.onInputChange(e)}>
                                </Form.Control>
                            </Form.Group>
                        </Col>
                        <Col xs="auto">
                            <Form.Group >
                                <Form.Label>Zemlja porekla</Form.Label>
                                <Form.Control
                                    placeholder="Zemlja porekla"
                                    size="sm"
                                    name="countryOfOrigin"
                                    as="input"
                                    type="text"
                                    onChange={(e) => this.onInputChange(e)}>
                                </Form.Control>
                            </Form.Group>
                        </Col>
                    </Row>

                    <Row>
                        <Col xs="auto">
                            <Form.Group>
                                <Form.Label>Projekcije</Form.Label>
                                <Form.Select
                                    defaultValue="Izaberite..."
                                    size="sm"
                                    name="projectionId"
                                    onChange={(e) => this.onInputChange(e)}>
                                    <option>Izaberite...</option>
                                    {this.state.projections.map((projection) => {
                                        return (
                                            <option key={projection.id} value={projection.id}>{projection.dateTimeOfDisplay}</option>
                                        );
                                    })}
                                </Form.Select>
                            </Form.Group>
                        </Col>
                        <Col xs="auto">
                            <Form.Group >
                                <Form.Label>Godina proizvodnje od:</Form.Label>
                                <Form.Control
                                    placeholder="Godina proizvodnje od:"
                                    size="sm"
                                    name="yearOfProductionFrom"
                                    as="input"
                                    type="number"
                                    onChange={(e) => this.onInputChange(e)}>
                                </Form.Control>
                            </Form.Group>
                        </Col>
                        <Col xs="auto">
                            <Form.Group >
                                <Form.Label>Godina proizvodnje do:</Form.Label>
                                <Form.Control
                                    placeholder="Godina proizvodnje do:"
                                    size="sm"
                                    name="yearOfProductionTo"
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
                            <Button size="sm" variant="outline-secondary" onClick={() => this.getMovies()}>Search</Button>
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

                    <Table className="table123" style={{ marginTop: 10 }} size="xl"  >
                        <thead className="custom-header">
                            <tr >
                                <th><p2>Naziv</p2></th>
                                <th><p2>Zanrovi</p2></th>
                                <th><p2>Trajanje</p2></th>
                                <th><p2>Distributer</p2></th>
                                <th><p2>Zemlja porekla</p2></th>
                                <th><p2>Godina proizvodnje</p2></th>
                                {/* <th><p2>Projekcija</p2></th> */}
                                <th></th><th></th><th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.movies.map((movie) => {
                                return (
                                    <tr key={movie.id}>
                                        <Button variant="default" onClick={() => this.goToMovie(movie.id)}>{movie.name}</Button>
                                        {/* <td>{movie.name}</td> */}
                                        <td>{movie.genres}</td>
                                        <td>{movie.duration}</td>
                                        <td>{movie.distributor}</td>
                                        <td>{movie.countryOfOrigin}</td>
                                        <td>{movie.yearOfProduction}</td>
                                        {window.localStorage['role'] == 'ROLE_ADMIN' ?
                                            <td><Button size="sm" variant="outline-warning" onClick={() => this.goToEdit(movie.id)}>Izmeni film</Button></td> : null}
                                        {window.localStorage['role'] == 'ROLE_ADMIN' ?
                                            <td><Button size="sm" variant="outline-danger" onClick={() => this.goToDelete(movie.id)}>Obrisi film</Button></td> : null}
                                        <Row><Col>
                                            {window.localStorage['role'] == 'ROLE_ADMIN' ?
                                                <Button size="sm" variant="outline-success" onClick={() => this.goToAdd()}>Dodaj novi film</Button> : null}
                                        </Col></Row>

                                    </tr>
                                );
                            })}
                        </tbody>
                    </Table>

                    <Button size="sm" variant="outline-primary" disabled={this.pageNo === 0} onClick={() => this.getMovies(this.pageNo - 1)} className="mr-3">Prev</Button>
                    <Button size="sm" variant="outline-primary" disabled={this.pageNo == this.totalPages - 1} onClick={() => this.getMovies(this.pageNo + 1)} className="mr-3">Next</Button>
                </Col></Row>
            </Col>
        )
    }

}

export default withNavigation(withParams(Movies))
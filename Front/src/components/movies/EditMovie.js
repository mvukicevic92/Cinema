import React from "react";
import Axios from "../../apis/Axios";
import { Button, Col, Form, Row } from 'react-bootstrap';
import { withNavigation, withParams } from '../../routeconf'

class EditMovie extends React.Component {

    state = {
        movieId: -1,
        movieName: "",
        movieDirector: "",
        movieActors: "",
        movieGenres: "",
        movieDuration: 0,
        movieDistributor: "",
        movieCountryOfOrigin: "",
        movieYearOfProduction: 0,
        movieDescription: "",
        movieProjectionId: 0,
        movieProjectionName: "",
        projections: []
    }

    componentDidMount() {
        var id = this.props.params.id
        this.getProjections()
        this.getMovieById(id)
    }

    async getProjections() {
        try {
            let result = await Axios.get("/projections")
            let projections = result.data
            this.setState({ projections: projections })
            console.log("Loading projections")
        } catch (error) {
            console.log(error)
            alert("Projections can't be found")
        }
    }

    getMovieById(movieId) {
        Axios.get("/movies/" + movieId)
            .then(res => {
                console.log(res)
                this.setState({
                    movieId: res.data.id,
                    movieName: res.data.name,
                    movieDirector: res.data.director,
                    movieActors: res.data.actors,
                    movieGenres: res.data.genres,
                    movieDuration: res.data.duration,
                    movieDistributor: res.data.distributor,
                    movieCountryOfOrigin: res.data.countryOfOrigin,
                    movieYearOfProduction: res.data.yearOfProduction,
                    movieDescription: res.data.description,
                    movieProjectionId: res.data.projectionId,
                    movieProjectionName: res.data.projectionName
                })
            })
            .catch(error => {
                console.log(error)
            })
    }

    edit(movieId) {
        var params = {
            "id": this.state.movieId,
            "name": this.state.movieName,
            "director": this.state.movieDirector,
            "actors": this.state.movieActors,
            "genres": this.state.movieGenres,
            "duration": this.state.movieDuration,
            "distributor": this.state.movieDistributor,
            "countryOfOrigin": this.state.movieCountryOfOrigin,
            "yearOfProduction": this.state.movieYearOfProduction,
            "description" : this.state.movieDescription,
            "projectionId": this.state.movieProjectionId,
            "projectionName": this.state.movieProjectionName
        }

        Axios.put("/movies/" + this.state.movieId, params)
            .then(res => {
                console.log(res)
                this.props.navigate("/movies")
            })
            .catch(error => {
                console.log(error)
            })
    }

    onNameChange(e) {
        console.log(e.target.value)
        this.setState({ movieName: e.target.value })
    }

    onDirectorChange(e) {
        console.log(e.target.value)
        this.setState({ movieDirector: e.target.value })
    }

    onActorsChange(e) {
        console.log(e.target.value)
        this.setState({ movieActors: e.target.value })
    }

    onGenresChange(e) {
        console.log(e.target.value)
        this.setState({ movieGenres: e.target.value })
    }

    onDurationChange(e) {
        console.log(e.target.value)
        this.setState({ movieDuration: e.target.value })
    }

    onDistributorChange(e) {
        console.log(e.target.value)
        this.setState({ movieDistributor: e.target.value })
    }

    onCountryOfOriginChange(e) {
        console.log(e.target.value)
        this.setState({ movieCountryOfOrigin: e.target.value })
    }

    onYearOfProductionChange(e) {
        console.log(e.target.value)
        this.setState({ movieYearOfProduction: e.target.value })
    }

    onDescriptionChange(e) {
        console.log(e.target.value)
        this.setState({ movieDescription: e.target.value })
    }

    projectionSelectionChanged(e) {
        let projectionId = e.target.value
        let projection = this.state.projections.find((projection) => projection.id == projectionId)

        this.state.movieProjectionId = projection.id
        this.state.movieProjectionName = projection.name
    }

    render() {
        return (
            <>
                <Row>
                    <Col></Col>
                    <Col xs="12" sm="10" md="8">
                        <h1>Edit movie</h1>
                        <Form>
                            <Form.Group>
                                <Form.Label htmlFor="ime">Name</Form.Label>
                                <Form.Control id="name" name="name" value={this.state.wineName} onChange={(e) => this.onNameChange(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label htmlFor="director">Director</Form.Label>
                                <Form.Control id="director" name="director" type="text" value={this.state.movieDirector} onChange={(e) => this.onDirectorChange(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label htmlFor="actors">Actors</Form.Label>
                                <Form.Control id="actors" name="actors" value={this.state.movieActors} onChange={(e) => this.onActorsChange(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label htmlFor="genres">Genres</Form.Label>
                                <Form.Control id="genres" name="genres" type="text" value={this.state.movieGenres} onChange={(e) => this.onGenresChange(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label htmlFor="duration">Duration</Form.Label>
                                <Form.Control id="duration" name="duration" type="number" value={this.state.movieDuration} onChange={(e) => this.onDurationChange(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label htmlFor="distributor">Distributor</Form.Label>
                                <Form.Control id="distributor" name="distributor" type="text" value={this.state.movieDistributor} onChange={(e) => this.onDistributorChange(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label htmlFor="countryOfOrigin">Country of origin</Form.Label>
                                <Form.Control id="countryOfOrigin" name="countryOfOrigin" value={this.state.movieCountryOfOrigin} onChange={(e) => this.onCountryOfOriginChange(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label htmlFor="yearOfProduction">Year of production</Form.Label>
                                <Form.Control id="yearOfProduction" name="yearOfProduction" type="number" value={this.state.movieYearOfProduction} onChange={(e) => this.onYearOfProductionChange(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label htmlFor="description">Description</Form.Label>
                                <Form.Control id="description" name="description" type="text" value={this.state.movieDescription} onChange={(e) => this.onDescriptionChange(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label htmlFor="projectionId">Projection</Form.Label>
                                <Form.Control as="select" id="projectionId" onChange={event => this.projectionSelectionChanged(event)}>
                                    <option>{this.state.movieProjectionName}</option>
                                    {
                                        this.state.projections.map((projection) => {
                                            return (
                                                <option key={projection.id} value={projection.id}>{projection.dateTimeOfDisplay}</option>
                                            )
                                        })
                                    }
                                </Form.Control><br />
                            </Form.Group>

                            <Button onClick={() => this.edit(this.state.movieId)}>Edit</Button>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>
            </>
        )
    }



}

export default withParams(withNavigation(EditMovie))
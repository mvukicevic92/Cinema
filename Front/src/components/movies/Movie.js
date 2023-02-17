import React from "react";
import { Row, Col, Button, Table, Form } from 'react-bootstrap'
import Axios from "../../apis/Axios";
import { withParams, withNavigation } from '../../routeconf';
import './../../index.css';


class Movie extends React.Component {

    constructor(props) {
        super(props)

        this.pageNo = 0;
        this.totalPages = 0;

        this.state = {
            movieId: 1,
            name: "",
            director: "",
            actors: "",
            genres: "",
            duration: 0,
            distributor: "",
            countryOfOrigin: "",
            yearOfProduction: 0,
            description: "",

        }

    }

    componentDidMount() {
        var id = this.props.params.id
        this.getMovieById(id)
        this.getProjections()
    }

    getMovieById(movieId) {
        Axios.get("/movies/" + movieId)
            .then((res) => {
                console.log(res)
                this.setState({
                    movieId: res.data.id,
                    name: res.data.name,
                    director: res.data.director,
                    actors: res.data.actors,
                    genres: res.data.genres,
                    duration: res.data.duration,
                    distributor: res.data.distributor,
                    countryOfOrigin: res.data.countryOfOrigin,
                    yearOfProduction: res.data.yearOfProduction,
                    description: res.data.description
                })
            })
            .catch((error) => {
                console.log(error)
            })
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

    render() {
        return (
            <Row><Col>

                <Table className="table123" style={{ marginTop: 10 }} size="xl" >
                    <thead className="custom-header">
                        <tr>
                            <th><p2>Naziv</p2></th>
                            <th><p2>Direktor</p2></th>
                            <th><p2>Glumci</p2></th>
                            <th><p2>Zanrovi</p2></th>
                            <th><p2>Trajanje</p2></th>
                            <th><p2>Distributer</p2></th>
                            <th><p2>Zemlja porekla</p2></th>
                            <th><p2>Godina proizvodnje</p2></th>
                            <th><p2>Opis</p2></th>
                        </tr>
                    </thead>
                    <tbody>


                        <tr key={this.state.movieId}>
                            <td>{this.state.name}</td>
                            <td>{this.state.director}</td>
                            <td>{this.state.actors}</td>
                            <td>{this.state.genres}</td>
                            <td>{this.state.duration}</td>
                            <td>{this.state.distributor}</td>
                            <td>{this.state.countryOfOrigin}</td>
                            <td>{this.state.yearOfProduction}</td>
                            <td>{this.state.description}</td>
                        </tr>


                    </tbody>
                </Table>
            </Col></Row>
        )
    }

}

export default withNavigation(withParams(Movie))
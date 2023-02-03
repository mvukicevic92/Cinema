import React from "react";
import { Row, Col, Button, Table, Form } from 'react-bootstrap'
import Axios from "../../apis/Axios";
import { withParams, withNavigation } from '../../routeconf';
import './../../index.css';


class Users extends React.Component {

    constructor(props) {
        super(props)

        this.pageNo = 0;
        this.totalPages = 0;

        this.state = {
            users: []
        }
    }

    componentDidMount() {
        this.getUsers(0)
    }

    getUsers() {
        Axios.get("/users")
            .then((res) => {
                this.setState({ users: res.data })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    render() {
        return (
            <Row><Col>
                <Table style={{ marginTop: 10 }} size="xl" >
                    <thead>
                        <tr>
                            <th>Korisnicko ime: </th>
                            <th>Datum registracije: </th>
                            <th>Uloga: </th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.users.map((user) => {
                            return (
                                <tr key={user.id}>
                                    <td>{user.username}</td>
                                    <td>{user.dateOfRegistration}</td>
                                    <td>{window.localStorage.getItem('role')}</td>
                                </tr>
                            );
                        })}
                    </tbody>
                </Table>
                <Button size="sm" variant="outline-primary" disabled={this.pageNo === 0} onClick={() => this.getMovies(this.pageNo - 1)} className="mr-3">Prev</Button>
                <Button size="sm" variant="outline-primary" disabled={this.pageNo == this.totalPages - 1} onClick={() => this.getMovies(this.pageNo + 1)} className="mr-3">Next</Button>
            </Col></Row>

        )
    }

}

export default withNavigation(withParams(Users))
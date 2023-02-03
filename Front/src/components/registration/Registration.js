import React from 'react';
import { Row, Col, Form, Button } from "react-bootstrap";
import Axios from '../../apis/Axios';
import { withParams, withNavigation } from '../../routeconf';

class Registration extends React.Component {

    constructor(props) {
        super(props)

        let user = {
            username: "",
            // dateOfRegistration: "",
            password: "",
            repeatedPassword: ""
        }

        this.state = { user: user }
    }

    async create(e) {
        e.preventDefault()

        try {
            let user = this.state.user
            let UserRegistrationDto = {
                username: user.username,
                // dateOfRegistration: user.dateOfRegistration,
                password: user.password,
                repeatedPassword: user.repeatedPassword
            }

            let response = await Axios.post("/users", UserRegistrationDto)
            this.props.navigate("/users")
        } catch (error) {
            alert("Korisnik nije registrovan!")
        }
    }

    valueInputChanged(e) {
        let input = e.target;

        let name = input.name;
        let value = input.value;

        let user = this.state.user;
        user[name] = value;

        this.setState({ user: user });
    }

    render() {
        return (
            <Row className="justify-content-center">
                <Col md={6}>
                    <Form>
                        <Form.Group>
                            <Form.Label>Korisnicko ime: </Form.Label>
                            <Form.Control type="text" name="username" onChange={(e) => this.valueInputChanged(e)}></Form.Control>
                        </Form.Group>
                        {/* <Form.Group>
                        <Form.Label>Datum registracije: </Form.Label>
                        <Form.Control type="text" name="dateOfRegistration" onChange={(e)=>this.valueInputChanged(e)}></Form.Control>
                    </Form.Group> */}
                        <Form.Group>
                            <Form.Label>Lozinka: </Form.Label>
                            <Form.Control type="password" name="password" onChange={(e) => this.valueInputChanged(e)}></Form.Control>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Ponovljena lozinka: </Form.Label>
                            <Form.Control type="password" name="repeatedPassword" onChange={(e) => this.valueInputChanged(e)}></Form.Control>
                        </Form.Group>
                        <br />
                    </Form>
                    <Button onClick={(event) => { this.create(event); }}>Registracija</Button>
                </Col>
            </Row>
        )

    }

}
export default withNavigation(Registration);
import React from "react";
import { Row, Col, Button, Table, Form } from 'react-bootstrap'
import Axios from "../../apis/Axios";
import { withParams, withNavigation } from '../../routeconf';
import './../../index.css';


class Tickets extends React.Component {

    constructor(props) {
        super(props)

        this.pageNo = 0;
        this.totalPages = 0;

        this.state = {
            tickets: [],
            projections: [],
            seats: []
        }

    }

    componentDidMount() {
        this.getTickets(0)
        this.getProjections()
        this.getSeats()
    }

    async getTickets(newPageNo) {

        let config = {
            params: {
                pageNo: newPageNo
            }
        }

        try {
            let result = await Axios.get("/tickets", config)
            this.pageNo = newPageNo
            this.totalPages = result.headers["total-pages"]
            this.setState({
                tickets: result.data
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

    getSeats() {
        Axios.get("/seats")
            .then((res) => {
                this.setState({ seats: res.data })
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
                                <th><p2>Projekcija</p2></th>
                                <th><p2>Sediste</p2></th>
                                <th><p2>Datum kupovine</p2></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.tickets.map((ticket) => {
                                return (
                                    <tr key={ticket.id}>
                                        <td>{ticket.projection.dateTimeOfDisplay}</td>
                                        <td>{ticket.seat.serialNumber}</td>
                                        <td>{ticket.dateTimeOfPurchase}</td>
                                    </tr>
                                );
                            })}
                        </tbody>
                    </Table>

                    <Button size="sm" variant="outline-primary" disabled={this.pageNo === 0} onClick={() => this.getTickets(this.pageNo - 1)} className="mr-3">Prev</Button>
                    <Button size="sm" variant="outline-primary" disabled={this.pageNo == this.totalPages - 1} onClick={() => this.getTickets(this.pageNo + 1)} className="mr-3">Next</Button>
                </Col></Row>
        )
    }

}

export default withNavigation(withParams(Tickets))
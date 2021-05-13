import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';

class EditCustomer extends Component {
    constructor(props) {
        console.log(props)
        super(props);
        this.state = {
            id: "",
            firstName: "",
            lastName: "",
            email: ""
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount = () => {
        console.log(this.props.location)
        const { customer } = this.props.location.state;
        this.setState({
            id: customer.id,
            firstName: customer.firstName,
            lastName: customer.lastName,
            email: customer.email
        });
    }

    handleSubmit = e => {
        e.preventDefault();
        const { id, firstName, lastName, email } = this.state;
        const url = "http://localhost:8080/customers/" + id;
        fetch(url, {
            method: "PUT",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName,
                email: email
            })
        })
        this.props.history.push('/view')
    }

    handleInputChange = e => {
        const target = e.target;
        const value = target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
        
    }

    render() {
        return (
        <form onSubmit={this.handleSubmit}>
            <label>
                First Name:
                <input type="text" name="firstName" value={this.state.firstName} onChange={this.handleInputChange}></input>
            </label>
            <br/>
            <label>
                Last Name:
                <input type="text" name="lastName" value={this.state.lastName} onChange={this.handleInputChange}></input>
            </label>
            <br/>
            <label>
                Email:
                <input type="text" name="email" value={this.state.email} onChange={this.handleInputChange}></input>
            </label>
            <br/>
            <button type="submit">Save</button>
        </form>
        )
    }
}

export default withRouter(EditCustomer);
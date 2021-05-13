import React, { Component } from 'react';
import { withRouter, Link } from 'react-router-dom';

class AddCustomer extends Component {
    constructor(props) {
        super(props);
        this.state = {
            firstName: "",
            lastName: "",
            email: ""
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount = () => {
    }

    handleSubmit = e => {
        e.preventDefault();
        const { firstName, lastName, email } = this.state;
        const url = "http://localhost:8080/customers";
        fetch(url, {
            method: "POST",
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
            <button type="submit">Add</button>
        </form>
        )
    }
}

export default withRouter(AddCustomer);
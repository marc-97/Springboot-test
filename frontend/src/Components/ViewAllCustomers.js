import React, { Component } from 'react';
import ReactTable from 'react-table-6';
import 'react-table-6/react-table.css';
import { withRouter, Link } from 'react-router-dom'

class ViewAllCustomers extends Component {
    constructor() {
        super();
        this.state = {
            customers: []
        };
        
        this.handleDelete = this.handleDelete.bind(this);
    }

    componentDidMount = () => {
        this.fetchData();
    };
    
    fetchData = () => {
        fetch("http://localhost:8080/customers", {
            method: "GET",
        }).then(response => {
            return response.json();
        }).then(res => {
            console.log(res)
            this.setState({customers: res})
        }).catch(err => console.log(err));
    }

    handleDelete = id => {
        const url = "http://localhost:8080/customers/" + id;
        fetch(url, {
            method: "DELETE",
        })
        window.location.reload();
    }

    render() {
        const { customers } = this.state;
        const columns = [
            {
              Header: 'First name',
              id: 'fn',
              accessor: 'firstName',
              style: { textAlign: 'center' },
            },
            {
                Header: 'Last name',
                id: 'ln',
                accessor: 'lastName',
                style: { textAlign: 'center' },
            },
            {
                Header: 'Email',
                id: 'email',
                accessor: 'email',
                style: { textAlign: 'center' },
            },
            {
                id: 'edit',
                accessor: "id",
                Cell: value => {
                    return (
                        <div>
                        <Link to={{
                            pathname: "/edit",
                            state: {customer: value.original}
                        }}
                        >
                            Edit
                        </Link>
                        <button onClick={() => {this.handleDelete(value.original.id)}}>Delete</button>
                        </div>
                    )
                }
            }
        ]

        return( 
            <div>
                <ReactTable 
                    columns={columns}
                    data={customers}
                >
                </ReactTable>
                <Link to={{
                    pathname: "/add"
                }}
                >
                    Add
                </Link>
            </div>

        );
    }
}

export default withRouter(ViewAllCustomers)
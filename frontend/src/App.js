import './App.css';
import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import ViewAllCustomers from './Components/ViewAllCustomers';
import EditCustomer from './Components/EditCustomer';
import AddCustomer from './Components/AddCustomer';

class App extends Component {
    constructor(props) {
        super();
    }
    
    render() {
        return (
            <Router>
            <Switch>
                <React.Fragment>

                {/* View Page */}
                <Route path='/View'>
                <ViewAllCustomers />
                </Route>

                {/* Edit Page */}
                <Route path='/Edit'>
                <EditCustomer />
                </Route>

                {/* Edit Page */}
                <Route path='/Add'>
                <AddCustomer />
                </Route>

                </React.Fragment>
            </Switch>

            </Router>
        );
    }
}

export default App;

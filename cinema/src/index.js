import React from 'react';
import ReactDOM from 'react-dom';
import { Route, Link, HashRouter as Router, Switch } from "react-router-dom";
import { Navbar, Nav, Container,Button} from "react-bootstrap";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import Movies from "./components/movies/Movies";
import AddMovie from "./components/movies/AddMovie";
import EditMovie from "./components/movies/EditMovie";
 import 'bootstrap/dist/css/bootstrap.min.css';

 import Projection from "./components/projection/Projection";
import Ticket from "./components/Ticket/Ticket";
 import BuyTicket from './components/Ticket/BuyTicket';
 import AllProjection from './components/projection/AllProjection';
 import addProjection from './components/projection/AddProjection';


// import './../public/bootstrap.css'

import Login from "./components/login/Login"
import { logout } from "./services/auth";
 


//import './index.css';




class App extends React.Component {
  render() {
    return (
      <div>
        <Router>
        <Navbar bg="dark" variant="dark" expand>
            <Navbar.Brand as={Link} to="/">
           
              Cinema
            </Navbar.Brand>
            <Nav className="mr-auto">
              <Nav.Link as={Link} to="/movies">
                Movies
              </Nav.Link>
              <Nav.Link as={Link} to="/Allprojection">
                Projection
              </Nav.Link>
              {window.localStorage['jwt'] ? 
                   <Nav.Link as={Link} to="/ticket">ticket</Nav.Link> :
                  <Nav.Link ></Nav.Link>
              }



              
            </Nav>


            {window.localStorage['jwt'] ? 
                  <Button onClick = {()=>logout()}>Log out</Button> :
                  <Nav.Link as={Link} to="/login">Log in</Nav.Link>
              }

          </Navbar>
          <Container style={{ paddingTop: "25px" }}>
            <Switch>

              <Route exact path="/movies" component={Movies} />
              <Route exact path="/movies/add" component={AddMovie} />
              <Route exact path="/movies/edit/:id" component={EditMovie} />
              <Route exact path="/login" component={Login} />
              <Route exact path="/projection/:id" component={Projection} />
              <Route exact path="/ticket" component={Ticket} />
              <Route exact path="/ticket/buy:id" component={BuyTicket} />
              <Route exact path="/Allprojection" component={AllProjection} />
              <Route exact path="/projectionAdd/:id" component={addProjection} />
          


             


              <Route exact path="/" component={Home} />
              <Route component={NotFound} />
            </Switch>
          </Container>
        </Router>
      </div>
    );
  }
}

ReactDOM.render(<App />, document.querySelector("#root"));



// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals


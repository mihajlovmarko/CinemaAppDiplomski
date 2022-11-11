import React from 'react';
import { Form, Button, Row, Col, InputGroup } from "react-bootstrap";import CinemaAxios from '../../apis/Axios'


class BuyTicket extends React.Component{

    constructor(props) {
        super(props);
      
        const jwt = window.localStorage['id'];
        let novaKarta = {
          seatNumber: "",
          reserved: "",
          
          projectionID: this.props.match.params.id,
          userId: jwt
           
        }
    
    
        this.state = {
            novaKarta: novaKarta,
          
        };
    
    
    
        this.pageNo = 0
        this.totalPages = 0
      }
    
    
      componentDidMount() {
    
      }


      
  changeInputValue(e) {
    const name = e.target.name
    const value = e.target.value

    let novaKarta = this.state.novaKarta

    novaKarta[name] = value
    this.setState({ novaKarta: novaKarta })

  }


  kupiKartu() {

    CinemaAxios.post('/ticket', this.state.novaKarta)
      .then(res => {
        alert("Uspesno kupljena karta")
   
        window.location.reload()
        
      })
      .catch(err => {
        console.log(err)
        alert("Kupovina neuspesna!")
      })
  }


  

  render() {
    return (

      <>

        <Col>
          <h3>Rezervacija karte</h3>

          <Form>
            <Form.Label htmlFor="seatNumber">seatNumber</Form.Label>
            <Form.Control name="seatNumber" onChange={(e) => { this.changeInputValue(e) }} />

            <Form.Label htmlFor="reserved">reserved</Form.Label>
            <Form.Control name="reserved" onChange={(e) => { this.changeInputValue(e) }} />

            
 
            <Form.Label htmlFor="projectionID">projectionID</Form.Label>
            <Form.Control name="projectionID" type="number"   value={this.props.match.params.id} />

            <Form.Label htmlFor="userId">KorisnikId</Form.Label>
            <Form.Control name="userId" type="number"   value={ window.localStorage.id} />
 




            <Button style={{ marginTop: "25px" }} onClick={() => this.kupiKartu()}>
              Dodaj
            </Button>
          </Form>
        </Col>




      </>

    );

  }



}export default BuyTicket;

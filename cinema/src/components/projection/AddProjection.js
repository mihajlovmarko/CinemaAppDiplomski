import React from "react";
import { Form, Button, Row, Col, InputGroup } from "react-bootstrap";
import CinemaAxios from "./../../apis/Axios";

class addProjection extends React.Component {

    constructor(props) {
        super(props);
    
        let novaProjekcija = {
          
            dateAndTime: "",
            theatre:0,
            filmId: this.props.match.params.id,
          price:0
        }
    
    
        this.state = {
            novaProjekcija: novaProjekcija,
    
        };
    
    
    
        this.pageNo = 0
        this.totalPages = 0
      }

      changeInputValue(e) {
        const name = e.target.name
        const value = e.target.value
    
        let novaProjekcija = this.state.novaProjekcija
    
        novaProjekcija[name] = value
        this.setState({ novaProjekcija: novaProjekcija })
    
      }

      dodajProjekciju() {

        CinemaAxios.post('/projection', this.state.novaProjekcija, {
          headers: {
              'Authorization': `Bearer ${localStorage.getItem("jwt")}`
          }
      })
          .then(res => {
            alert("Uspesno dodaata projekcija!")
             
    
            window.location.reload()
    
          })
          .catch(err => {
            console.log(err)
            alert("Dodavanje neuspesno!")
          })
      }



      

  render() {
    return (

      <>

        <Col>
          <h3>Dodavanje projekcije</h3>

          <Form>
            
            <Form.Label htmlFor="theatre">theater</Form.Label>
            <Form.Control name="theatre" type="number" onChange={(e) => { this.changeInputValue(e) }} />

           
            <Form.Label htmlFor="price">price</Form.Label>
            <Form.Control name="price" type="number" onChange={(e) => { this.changeInputValue(e) }} />

            <Form.Label htmlFor="dateAndTime">datumIVreme</Form.Label>
            <Form.Control name="dateAndTime"   onChange={(e) => { this.changeInputValue(e) }} />


            2020-06-22T20:00



            <Button style={{ marginTop: "25px" }} onClick={() => this.dodajProjekciju()}>
              Dodaj
            </Button>
          </Form>
        </Col>




      </>

    );

  }
    

}export default addProjection;

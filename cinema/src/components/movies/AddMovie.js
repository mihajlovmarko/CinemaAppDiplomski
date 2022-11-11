import React from "react";
import { Form, Button, Row, Col, InputGroup } from "react-bootstrap";
import CinemaAxios from "./../../apis/Axios";


class AddMovie extends React.Component {

  constructor(props) {
    super(props);

    let noviFilm = {
      filmName: "",
      duration: 0,
      director: "",
      year: 0,
      // ganres: {},
    }


    this.state = {
      noviFilm: noviFilm,
      // ganres: []

    };



    this.pageNo = 0
    this.totalPages = 0
  }


 


  componentDidMount() {
    // this.getGanres();
  }

  changeInputValue(e) {
    const name = e.target.name
    const value = e.target.value

    let noviFilm = this.state.noviFilm

    noviFilm[name] = value
    this.setState({ noviFilm: noviFilm })

  }


  getGanres(){
    CinemaAxios.get('/ganres',  {
          headers: {
              'Authorization': `Bearer ${localStorage.getItem("jwt")}`
          }
      })
    .then(res =>{
      this.setState({ganres: res.data})
      console.log(res);
    })
    .catch(err=>{
      console.log(err)
    })
}

  dodajFilm() {

    CinemaAxios.post('/movies', this.state.noviFilm, {
      headers: {
          'Authorization': `Bearer ${localStorage.getItem("jwt")}`
      }
  })
      .then(res => {
        alert("Uspesno dodat film!")

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
          <h3>Dodavanje filma</h3>

          <Form>
            <Form.Label htmlFor="filmName">Ime</Form.Label>
            <Form.Control name="filmName" onChange={(e) => { this.changeInputValue(e) }} />

            <Form.Label htmlFor="duration">duration</Form.Label>
            <Form.Control name="duration" type="number" onChange={(e) => { this.changeInputValue(e) }} />

            <Form.Label htmlFor="director">director</Form.Label>
            <Form.Control name="director" onChange={(e) => { this.changeInputValue(e) }} />

            <Form.Label htmlFor="year">year</Form.Label>
            <Form.Control name="year" type="number" onChange={(e) => { this.changeInputValue(e) }} />

            {/* <Form.Label htmlFor="ganre">Ganre</Form.Label>
                        <Form.Control as="select" name="ganres" onChange={ (e)=> { this.changeInputValue(e) }}>
                            <option></option>
                            {
                                this.state.ganres.map((p) => {
                                    return (
                                        <option key={p.id} value={p.id}>{p.nameGanre}</option>
                                    )
                                })
                            }
                        </Form.Control><br/> */}





            <Button style={{ marginTop: "25px" }} onClick={() => this.dodajFilm()}>
              Dodaj
            </Button>
          </Form>
        </Col>




      </>

    );

  }



} export default AddMovie;
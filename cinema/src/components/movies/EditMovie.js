import React from "react";
import { Form, Button, Row, Col, InputGroup } from "react-bootstrap";
import CinemaAxios from "./../../apis/Axios";



class EditMovie extends React.Component {


    constructor(props) {
        super(props);
    
        let movie = {
          filmName: "",
          duration: 0,
          director: "",
          year: 0
        }
    
    
        this.state = {
          movie: movie,
          
        };
    
    
    
        this.pageNo = 0
        this.totalPages = 0
      }

      componentDidMount() {
        this.getMovieBy(this.props.match.params.id);
     }

     

      getMovieBy(id){
        CinemaAxios.get('/movies/' + id, {
          headers: {
              'Authorization': `Bearer ${localStorage.getItem("jwt")}`
          }
      })
            .then(res=>{
                this.setState({movie: res.data})
                console.log(this.state)
            })
            .catch(err=>{
                console.log(err)
            })
      }

      

      changeInputValue(e) {
        const name = e.target.name
        const value = e.target.value
    
        let movie = this.state.movie
    
        movie[name] = value
        this.setState({ movie: movie })
    
      }

      izmeni(){
        CinemaAxios.put('/movies/' + this.state.movie.id, this.state.movie, {
          headers: {
              'Authorization': `Bearer ${localStorage.getItem("jwt")}`
          }
      })
          .then(res=>{
              alert("Uspesno izmenjen film!")
              this.goToMovies();
            
          })
          .catch(err=>{
              alert("Film nije izmenjen!")
              console.log(err)
          })
    }


    goToMovies() {
      this.props.history.push('/movies');  
  }

    render() {
        return (
          <> 
          <Col>
            <h3>Izmena filma</h3>
    
            <Form>
              <Form.Label htmlFor="filmName">Ime</Form.Label>
              <Form.Control name="filmName" onChange={(e) => { this.changeInputValue(e)}} value={this.state.movie.filmName} />
    
              <Form.Label htmlFor="duration">duration</Form.Label>
              <Form.Control name="duration" type="number" onChange={(e) => { this.changeInputValue(e) }}value={this.state.movie.duration} />
    
              <Form.Label htmlFor="director">director</Form.Label>
              <Form.Control name="director"   onChange={(e) => { this.changeInputValue(e) }} value={this.state.movie.director}/>
    
              <Form.Label htmlFor="year">year</Form.Label>
              <Form.Control name="year" type="number" onChange={(e) => { this.changeInputValue(e) }}value={this.state.movie.year} />
    
    
               
    
    
              <Button variant="primary" style={{ marginTop: "25px" }} onClick={() => this.izmeni()}>
                  izmeni
              </Button>
            </Form>
          </Col>
    
          
    
    
          </>
    
        );
    
      }






}export default EditMovie;
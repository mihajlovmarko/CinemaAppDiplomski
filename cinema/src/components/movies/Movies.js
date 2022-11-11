import React from 'react';
import { Table, Button, Container, Nav, Collapse, Form, ButtonGroup } from 'react-bootstrap'
import CinemaAxios from './../../apis/Axios'

class Movies extends React.Component {




  constructor(props) {
    super(props);

    this.state = {
      movies: [],

      showSearch: false,
      search: { filmName: "", durationOf: 0, durationTo: 0 },
      pageNo: 0,
      totalPages: 1

    }
  }

  componentDidMount() {
    this.getMovies(0);
  }


  doSearch() {
    this.getMovies(0);
  }

  async getMovies(page) {
    let config = {
      params: {
        pageNo: page
      }
    };

    //Sledeca 2 if-a su tu zbog search-a
    if (this.state.search.filmName != "") {
      config.params.filmName = this.state.search.filmName;
    }

    if (this.state.search.durationOf != 0) {
      config.params.durationOf = this.state.search.durationOf;
    }

    if (this.state.search.durationTo != 0) {
      config.params.durationTo = this.state.search.durationTo;
    }

    try {
      let result = await CinemaAxios.get("/movies", config);
      
      if (result && result.status === 200) {
        this.setState({
          pageNo: page,
          movies: result.data,
          
          totalPages: result.headers["total-pages"],

        });

        console.log(result)
      }
    } catch (error) {
      alert("Nije uspelo dobavljanje.");
    }
  }

  goToAdd() {
    this.props.history.push('/movies/add');
  }

  goToEdit(id) {
    this.props.history.push('/movies/edit/' + id);
  }


  goToCreateProj(id) {
    this.props.history.push('/projectionAdd/' + id);
  }

  goToProjection(id) {
    this.props.history.push('/projection/' + id);
  }

  getGenresStringFromList(list) {
    const arrayList = Object.values(list).join(', ');
    return arrayList;
    //     arrayList.map(element => {

    //     })
    //    console.log(Object.values(list))
  }


  searchValueInputChange(event) {
    let control = event.target;

    let name = control.name;
    let value = control.value;

    let search = this.state.search;
    search[name] = value;

    this.setState({ search: search });
  }




  obrisiFilm(id) {
    CinemaAxios.delete('/movies/' + id, {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem("jwt")}`
      }
    })
      .then(res => {
        console.log(res.data)
        alert("Uspesno obrisan film!")
        this.getMovies(this.pageNo)
      })
      .catch(err => {
        console.log(err)
        alert("Brisanje neuspesno!")
      })
  }



  renderMovies() {
    return this.state.movies.map((movie, index) => {
      return (
        <tr key={movie.id}>
          <td> <Nav.Link onClick={() => this.goToProjection(movie.id)}>{movie.filmName}</Nav.Link> </td>
          <td>{movie.director}</td>
          <td>{movie.year}</td>
          <td>{movie.duration}</td>


          <td>{this.getGenresStringFromList(movie.ganres)}</td>

          {window.localStorage['role'] == 'ROLE_ADMIN' ?
            <td><Button variant="warning" onClick={() => this.goToEdit(movie.id)}>Edit</Button></td> :
            <Button variant='white'></Button>
          }


          {window.localStorage['role'] == 'ROLE_ADMIN' ?
            <td><Button variant="danger" onClick={() => this.obrisiFilm(movie.id)}>Delete</Button></td> :
            <Button variant='white'></Button>
          }

          {window.localStorage['role'] == 'ROLE_ADMIN' ?
            <td><Button variant="info" onClick={() => this.goToCreateProj(movie.id)}>add Projection</Button></td> :
            <Button variant='white'></Button>
          }




        </tr>
      )
    })
  }



  render() {
    return (
      <div>



        {/*Deo za Search*/}
        <Form.Group style={{ marginTop: 35 }}>
          <Form.Check type="checkbox" label="Show search form" onClick={(event) => this.setState({ showSearch: event.target.checked })} />
        </Form.Group>
        <Collapse in={this.state.showSearch}>
          <Form style={{ marginTop: 10 }}>
            <Form.Group>
              <Form.Label>Ime filma</Form.Label>
              <Form.Control
                value={this.state.search.filmName}
                name="filmName"
                as="input"
                onChange={(e) => this.searchValueInputChange(e)}
              ></Form.Control>
            </Form.Group>


            <Form.Group>
              <Form.Label>Trajanje Od</Form.Label>
              <Form.Control
                value={this.state.search.durationOf}
                name="durationOf"
                as="input"
                type="number"
                onChange={(e) => this.searchValueInputChange(e)}
              ></Form.Control>
            </Form.Group>

            <Form.Group>
              <Form.Label>Trajanje do</Form.Label>
              <Form.Control
                value={this.state.search.durationTo}
                name="durationTo"
                as="input"
                type="number"
                onChange={(e) => this.searchValueInputChange(e)}
              ></Form.Control>
            </Form.Group>

            <Button onClick={() => this.doSearch()}>Search</Button>
          </Form>
        </Collapse>



        {/*Deo za prikaz Task-a*/}
        <ButtonGroup style={{ marginTop: 25, float: "right" }}>
          <Button
            style={{ margin: 3, width: 90 }}
            disabled={this.state.pageNo == 0} onClick={() => this.getMovies(this.state.pageNo - 1)} >
            Previous
          </Button>
          <Button
            style={{ margin: 3, width: 90 }}
            disabled={this.state.pageNo == this.state.totalPages - 1} onClick={() => this.getMovies(this.state.pageNo + 1)}>
            Next
          </Button>
        </ButtonGroup>


        <h1>Movies</h1>

        <div>
          {window.localStorage['role'] == 'ROLE_ADMIN' ?
            <Button onClick={() => this.goToAdd()}>Add</Button> :
            <Button variant='white'></Button>
          }


          <br />

          <Table style={{ marginTop: 5 }}>
            <thead>
              <tr>
                <th>Name</th>
                <th>Director </th>
                <th>Year</th>
                <th>Duration (min)</th>
                <th>Ganres</th>
                <th></th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {this.renderMovies()}
            </tbody>
          </Table>
        </div>

      </div>
    );
  }
}

export default Movies;
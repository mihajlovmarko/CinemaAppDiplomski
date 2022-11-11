import React from "react";
import { Modal, Button, Table } from "react-bootstrap";

import CinemaAxios from "../../apis/CinemaAxios";

class SelectGenres extends React.Component {
  constructor(props) {
    super(props);

    this.state = { genres: [], selectedGenres: this.props.selectedGenres };

    this.isInSelectedGenres = this.isInSelectedGenres.bind(this);
    this.selectionOccured = this.selectionOccured.bind(this);
  }

  componentDidMount(){
    this.getGenres();
  }

  async getGenres() {
    try {
      let result = await CinemaAxios.get("/ganres");
      this.setState({ genres: result.data });
    } catch (error) {
      alert("Could not fetch genres.");
      console.log(error);
    }
  }

  isInSelectedGenres(genre){
    //console.log(Object.values(this.state.selectedGenres)) 
    return this.state.selectedGenres.some((alreadySelected => alreadySelected.nameGanre == genre.nameGanre));
  }

  selectionOccured(event, genre){
    let previouslySelectedGenres = this.state.selectedGenres;

    if(event.ctrlKey){
      if(!this.isInSelectedGenres(genre)){
        previouslySelectedGenres.push(genre);
        this.setState({selectedGenres: previouslySelectedGenres});
      }
    }
    else{
      this.setState({selectedGenres: [genre]});
    }
  }

  render() {
    return (
      <>
        <Modal
          show={this.props.show}
          onHide={this.props.handleClose}
          backdrop="static"
        >
          <Modal.Header closeButton>
            <Modal.Title>Select genres</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <div style={{ marginBottom: "5px" }}>
              <Button variant="info" onClick={() => this.props.finishSelection(this.state.selectedGenres)}>Select</Button>
            </div>

            <Table>
              <thead>
                <tr>
                  <th>Name</th>
                </tr>
              </thead>
              <tbody>
                {this.state.genres.map((g) => {
                  return (
                    <tr 
                      style={ this.isInSelectedGenres(g) ? { backgroundColor: "#23abed", color: "white" } : {}}
                      onClick={(event)=>this.selectionOccured(event, g)}
                      key={g.id}>
                      <td>{g.nameGanre}</td>
                    </tr>
                  );
                })}
              </tbody>
            </Table>
          </Modal.Body>
        </Modal>
      </>
    );
  }
}

export default SelectGenres;

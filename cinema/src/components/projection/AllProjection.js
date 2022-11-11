import React from 'react';
import {Table, Button, Container} from 'react-bootstrap'
import CinemaAxios from './../../apis/Axios'

class AllProjection extends React.Component{


    constructor(props) {
        super(props);

        this.state = { projection: []}
    }

    componentDidMount() {
      this.getProjection();
    }

    goToBuyTicket(id) {
        this.props.history.push('/ticket/buy' + id);  
    }


    getProjection() {
        CinemaAxios.get("/projection")
            .then(res => {
                 // handle success
                 console.log(res.data);
                  this.setState({projection: res.data});
            })
            .catch(error => {
                // handle error
                console.log(error);
                alert('Error occured please try again!');
            });
    }


    renderProjection() {
        return this.state.projection.map((projection, index) => {
            return (
               <tr key={projection.id}>
                  <td>{projection.filmNaziv}</td>
                  <td>{projection.dateAndTime}</td>
                  <td>{projection.price}</td>
                  <td>{projection.theatre}</td>
                  
              
                </tr>
            )
         })
    }





    
    render() {
        return (
            <div>
                <h1>Projection</h1>
                
                <div>
                     <br/>
                    
                    <Table style={{marginTop:5}}>
                        <thead>
                            <tr>
                                <th>Naziv Filma</th>
                                <th>Datum i vreme </th>
                                <th>cena</th>
                                <th>sala</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        {this.renderProjection()}
                        </tbody>                  
                    </Table>
                </div>
               
            </div>
        );
    }




}export default AllProjection;
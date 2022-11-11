import React from 'react';
import {Table, Button, Container} from 'react-bootstrap'
import CinemaAxios from './../../apis/Axios'


class Ticket extends React.Component{

    constructor(props) {

        
        super(props);
         


        this.state = { ticket: []}
    }

    componentDidMount() {
        this.getTicket(window.localStorage['id']);
    }


    getTicket(id) {
        CinemaAxios.get("korisnici/" + id + "/tickets", {
            headers: {
                'Authorization': `Bearer ${localStorage.getItem("jwt")}`
            }
        })
            .then(res => {
                 // handle success
                 console.log(res.data);
                  this.setState({ticket: res.data});
            })
            .catch(error => {
                // handle error
                console.log(error);
                alert('Error occured please try again!');
            });
    }

    
  

    
    obrisiKartu(id){
        CinemaAxios.delete('/ticket/' + id, {
            headers: {
                'Authorization': `Bearer ${localStorage.getItem("jwt")}`
            }
        })
            .then(res=>{
                console.log(res.data)
                alert("Uspesno obrisana karta!")
                this.getTicket(window.localStorage['id'])
            })
            .catch(err=>{
                console.log(err)
                alert("Brisanje neuspesno!")
            })
    }

    
    renderTicket() {
        return this.state.ticket.map((ticket, index) => {
            return (
               <tr key={ticket.id}>
                  <td>{ticket.seatNumber}</td>
                  <td>{ticket.reserved}</td>
                  <td>{ticket.nazivF}</td>
                  <td>{ticket.datumP}</td>
                  <td>{ticket.priceProjection}</td>
                   
                  
                  <Button  variant="outline-danger" onClick={() => this.obrisiKartu(ticket.id)}>Delete</Button>{' '}
                </tr>
            )
         })
    }





    
    render() {
        return (
            <div>
                <h1>Ticket</h1>
                
                <div>
                     <br/>
                    
                    <Table style={{marginTop:5}}>
                        <thead>
                            <tr>
                                <th>sediste</th>
                                <th>reserved </th>
                                <th>Film </th>
                                <th>datum </th>
                                <th>cena </th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        {this.renderTicket()}
                        </tbody>                  
                    </Table>
                </div>
               
            </div>
        );
    }



}export default Ticket;

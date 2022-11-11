import React from 'react';
import CinemaAxios from '../../apis/CinemaAxios'

class Genres extends React.Component{
    constructor(props){
        super(props);
    
        this.state = {ganres: []};
    
    }

    componentDidMount(){
        this.getGenres();
    }

    async getGenres(){
        try{
            let result = await CinemaAxios.get("/ganres");
            this.setState({ganres: result.data});
        }
        catch(error){
            alert("Could not fetch genres.");
            console.log(error);
        }
    }

    render(){
        return (
            <>
                <h1>Genres</h1>
                <table>
                    <tr>
                        <th>Name</th>
                    </tr>
                    {
                        this.state.genres.map(g => {
                            return (
                                <tr key={g.id}>
                                    <td>{g.nameGanre}</td>
                                    <td><button disabled={true}>Select</button></td>
                                </tr>
                            )
                        })
                    }
                </table>
            </>
        )
    }
}

export default Genres;
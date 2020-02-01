import React from 'react';
import axios from 'axios';


class Item extends React.Component{
  constructor(props){
    super(props);
  }

  render(){
    let item = this.props.data;
    return (
      <div className="row align-items-center" style={{borderBottom:'1px solid #eeeeee'}}>
        <div className="p-2">
          <a style={{fontSize:'14px'}} href="#" data-toggle="modal" data-target={"#modal-"+item.id}>{item.title}</a>
        </div>
        <div className="ml-auto ">
          <span style={{fontSize:'10px',color:'#757575', fontWeight:'bold'}} className="align-middle mr-3"><i className="material-icons mr-1" style={{verticalAlign:'middle', fontSize:'14px', color:'#9e9e9e'}}>thumb_up</i>{item.likes}</span>
        </div>

        <div className="modal fade" id={"modal-"+item.id} role="dialog" dd={item.id}>
          <div className="modal-dialog" role="document">
            <div className="modal-content">

              <div className="modal-header">
                <h5 className="modal-title" id="exampleModalLabel">{item.title}</h5>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>

              <div className="modal-body">
                {Object.keys(item.tags).map((key) => 
                  <div className="row ml-4" key={key}>
                    <div>
                      <span className="badge badge-secondary mr-1" style={{verticalAlign:'middle'}}>{key}</span><span style={{verticalAlign:'middle'}}>{item.tags[key]}</span>
                    </div>
                  </div>
                )}
              </div>

              <div className="modal-footer">
                <button type="button" className="btn btn-secondary" data-dismiss="modal">Close</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    )
  }
}

class Card extends React.Component{

  constructor(props){
    super(props);
  }

  render(){

    let card = this.props.data;
    return(
      <div className="row  shadow-sm rounded mb-2" style={{backgroundColor:"white"}}>
        <div className="col-12">
          <div className="row align-items-center p-1" style={{backgroundColor:card.header.background, color:card.header.color}}>
              <i className="material-icons" style={{verticalAlign:'middle', width:'24px'}}>{card.header.icon}</i>
              <span className="font-weight-bold pl-2">{card.header.title}</span>
          </div>
          {card.items.map((row, i) =>
            <Item key={i} data={row} />
          )}
        </div>
      </div>

    )
  }

}

class Favorites extends React.Component{

  constructor(props){
    super(props)

    this.state = {cpr:2, data:[]};
  }

  calculateRows(data){

    let calc = data.length / this.state.cpr;

    let rows = parseInt(calc);

    return calc % this.state.cpr == 0 ? rows : rows+1;
  }

  componentDidMount(){
    axios.get("http://localhost/api/v1/favorites", {headers:{'Access-Control-Allow-Origin':'*'}}).then(result => {
      this.setState({data:result.data});
    })
  }

  render(){

    let data = this.state.data;
    let rows = [];

    for (let i = 0,offset=0; i < this.calculateRows(data); i++){
      let _data = data.slice(offset, offset+this.state.cpr);
      offset = offset+this.state.cpr;
      rows.push(
        <div className="row justify-content-center" key={i}>
          {_data.map((row, idx) => 
            <div className="col mr-1" key={idx}>
              <Card data={row}/>
            </div>
          )}
        </div>
      )
    }


    return(
      <div>
        {rows}
      </div>
    )
  }
}

export default Favorites;
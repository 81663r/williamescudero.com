import React from 'react';
import axios from 'axios';


class Card extends React.Component{

  constructor(props){
    super(props);
  }


  render(){

    let project = this.props.data;
    let docs = project.docs;
    let rows = [];
    let details = [];

    return(
      <div className="row  shadow-sm rounded mb-2" style={{backgroundColor:'white'}}>
        <div className="col">
          <div className="row">

            <div className="col">
              <div className="row m-0 pl-2 pr-2 pt-2">
                <h4>{project.name}</h4>
              </div>

              <div className="row pl-4 pr-4 pt-0 pb-1">
                <p style={{color:'grey'}}>{project.description}</p>
              </div>
              
              {/**ACTION ROW */}
              <div className="row p-2 border-top align-items-center justify-content-center">

                <div className="col" style={{fontSize: '11px', color:'grey'}}>
                  <span> last update -> {project.lastUpdate}</span>
                </div>

                <div className="ml-auto">

                  {/** DDM SOURCE */}
                  <div className="dropdown btn-group">
                    <a href="#" style={{fontSize:'10px',color:'#757575', fontWeight:'bold'}} className="align-middle mr-3" data-toggle="dropdown" id={"project-source-"+project.id} aria-haspopup="true" aria-expanded="false"><i className="material-icons mr-1" style={{verticalAlign:'middle', fontSize:'14px', color:'#9e9e9e'}}>code</i>SOURCE</a>
                    <div className="dropdown-menu" aria-labelledby={"project-source-"+project.id} id={"project-source-"+project.id} style={{width:'300px'}}>
                      <div className="input-group input-group-sm pr-2 pl-2">
                        <input type="text" className="col-12 form-control" id={"project-source-container-"+project.id} aria-describedby="inputGroupAppend" value={project.source} readOnly={true}></input>
                        <div className="input-group-prepend">
                          <button className="btn btn-outline-secondary" type="button" id={"project-source-btn-"+project.id}><i className="material-icons p-0 m-0" style={{verticalAlign:'middle', fontSize:'16px'}}>file_copy</i></button>
                        </div>
                      </div>
                    </div>
                  </div>

                  {/** DDM DETAILS */}
                  <div className="dropdown btn-group">
                    <a href="#" style={{fontSize:'10px',color:'#757575', fontWeight:'bold'}} className="align-middle mr-3 dropdown" data-toggle="dropdown" id={"project-details-"+project.id} aria-haspopup="true" aria-expanded="false"><i className="material-icons mr-1" style={{verticalAlign:'middle', fontSize:'14px', color:'#9e9e9e'}}>details</i>DETAILS</a>
                    <div className="dropdown-menu" aria-labelledby={"project-details-"+project.id} id={"project-details-"+project.id}>
                      <div className="col">

                      <div className="row">
                        <div className="col-md-12">
                          {Object.keys(project.details).map((key) =>
                            <div className="row p-1" key={key}>
                              <div className="col">
                                <div className="row">
                                  <div className="col">
                                    <span className="badge badge-secondary">{key}</span>
                                  </div>
                                </div>
                                <div className="row">
                                  <div className="col">
                                    <span style={{fontSize:'10px'}}>{project.details[key]}</span>
                                  </div>
                                </div>
                              </div>
                            </div>
                          )}
                      </div>
                      </div>
                    </div>
                  </div>

                  {/** DDM DOCS */}
                  {/* <a href="#" style={{fontSize:'10px',color:'#757575', fontWeight:'bold'}} data-target={"#modal-"+project.id} data-toggle="modal" className="align-middle mr-3" id={"project-docs-"+project.id}><i className="material-icons mr-1" style={{verticalAlign:'middle', fontSize:'14px', color:'#9e9e9e'}}>description</i>DOCS</a> */}

                  <div className="modal fade" id={"modal-"+project.id} role="dialog">
                    <div className="modal-dialog" role="document">
                      <div className="modal-content">

                        <div className="modal-header">
                          <h5 className="modal-title" id="exampleModalLabel">{project.name}</h5>
                          <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>

                        <div className="modal-body">
                          {rows}
                        </div>

                        <div className="modal-footer">
                          <button type="button" className="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                      </div>
                    </div>
                  </div>

                </div>

              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
    )
  }
}

class Projects extends React.Component{

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
    axios.get("http://localhost:82/api/v1/projects", {headers:{'Access-Control-Allow-Origin':'*'}}).then(result => {
      this.setState({data:result.data});
    })
  }

  render(){
    // let data = [
    //   {
    //     id:'1', 
    //     name:'My first project', 
    //     source:'https://github.com/81663r/relay',
    //     docs:[
    //       {
    //         id:'1',
    //         type:'doc',
    //         name:'installation_manual.pdf',
    //       },
    //       {
    //         id:'2',
    //         type:'image',
    //         name:'screenshot1.jpg'
    //       }
    //     ],
    //     details:{
    //       version:'1.0.0',
    //       state:'in-progress',
    //       created:'01.04.2019, 02:34pm'
    //     }
    //   },
    //   {
    //     id:'2', 
    //     name:'My second project', 
    //     source:'https://github.com/81663r/relay',
    //     docs:[
    //       {
    //         id:'3',
    //         type:'doc',
    //         name:'installation_manual.pdf',
    //       },
    //       {
    //         id:'4',
    //         type:'image',
    //         name:'screenshot1.jpg'
    //       },
    //       {
    //         id:'5',
    //         type:'image',
    //         name:'screenshot1.jpg'
    //       }
    //     ],
    //     details:{}
    //   },
    //   {
    //     id:'3', 
    //     name:'My third project', 
    //     source:'https://github.com/81663r/relay',
    //     docs:[
    //       {
    //         id:'6',
    //         type:'doc',
    //         name:'installation_manual.pdf',
    //       },
    //       {
    //         id:'7',
    //         type:'image',
    //         name:'screenshot1.jpg'
    //       },
    //       {
    //         id:'8',
    //         type:'image',
    //         name:'screenshot1.jpg'
    //       }
    //     ],
    //     details:{}
    //   }
    // ];

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

export default Projects;
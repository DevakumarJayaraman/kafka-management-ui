
import React, { useEffect, useState } from 'react';
import {DataGrid} from '@material-ui/data-grid';
import Constants from './../../Utils/Constants';
import { makeStyles } from '@material-ui/core';

const useStyles = makeStyles(()=>({
  root:{
      height:"100px",
      "& .MuiDataGrid-footer":{
          justifyContent:"flex-end"
      }
  }  
}));

const TopicGrid = ()=>{
    console.log("Node Grid-->");
    const [nodeList,setNodeList] = useState([]);
    

    useEffect(()=>{
          fetch(Constants.BASE_URL+"/getCluster").then(res=>res.json())
          .then((res)=>{
              console.log("NodeInfoList",res?.clusterInfo?.nodeInfoList);
            setNodeList(res?.clusterInfo?.nodeInfoList?.map((rec)=>{rec.id = rec.nodeId; return rec;}));
          });
    },[]);

    const classes = useStyles();

    return (
        <div style={{ minHeight: 400,height:"100%", width: '100%' }}>
        <DataGrid className={classes.root}
            columns={[
                {field:'nodeId',headerName:"Broker Id"},                             
                {field:"address",headerName:"Broker Host Details",width:300},
                {field:'id',hide:true},   
            ]}
            rows={nodeList}
            hideFooterPagination={true}
        >
        </DataGrid>
        </div>
    );
}
export default TopicGrid;
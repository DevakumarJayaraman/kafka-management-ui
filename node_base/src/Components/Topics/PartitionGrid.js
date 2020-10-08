
import React, { useEffect } from 'react';
import {useLocation} from 'react-router-dom';
import {DataGrid} from '@material-ui/data-grid';
import Constants from './../../Utils/Constants';
import { makeStyles } from '@material-ui/core';

const useStyles = makeStyles(()=>({
  root:{
      height:"100px",
      "& .MuiDataGrid-footer":{
          justifyContent:"flex-end"
      },
      "& .MuiDataGrid-window":{
          overflowX:"hidden"
      }
  }  
}));

const PartitionGrid = ()=>{
    console.log("Node Grid-->");
    const {state:{partitionInfoList}} = useLocation();

   const formatPartition=(partitionInfoList)=>{
        return partitionInfoList?.map((partition)=>{
            partition.id = partition.partionId;
            return partition;
        });
    }
    
    useEffect(()=>{
          fetch(Constants.BASE_URL+"/getTopics").then(res=>res.json())
          .then((res)=>{
              console.log("NodeInfoList",res?.topicInfoList);
          });
    },[]);

    const classes = useStyles();
    const partitioinList = formatPartition(partitionInfoList)
    console.log("partitioinList",partitioinList);
    return (
        <div style={{ minHeight: 540,height:"100%", width: '100%' }}>
        <DataGrid className={classes.root}
        autoPageSize = {false}
            columns={[
                {field:'partionId',headerName:"Partion Id",width:100},                             
                {field:"leader",headerName:"Leader",width:200,
                    valueGetter:(params)=>{
                         return (
                             params.value.address
                         )   
                    }
                },
                {field:"replicas",headerName:"Replicas",width:450,
                    valueGetter:(params)=>{
                        return (
                            params?.value?.map(rec=>rec.address).join()
                        )   
                    }
                },
                {field:'id',hide:true,width:0}   
            ]}
            rows={partitioinList}
            hideFooterPagination={true}
        >
        </DataGrid>
        </div>
    );


}
export default PartitionGrid;
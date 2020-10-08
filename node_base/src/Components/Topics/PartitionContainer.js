
import { Grid, Typography,Fade  } from '@material-ui/core';
import React from 'react';
import {useLocation} from 'react-router-dom';
import PartitionGrid from './PartitionGrid';

const PartitionContainer = ()=>{
    const {state} = useLocation();

    return (
       <Fade  in={true}>
        <Grid container direction="column">  
             <Grid item xs={12}><Typography variant="h5" style={{padding:"20px"}}> Partition Details</Typography></Grid>         
             <Grid item xs={12}><Typography variant="subtitle2" style={{padding:"10px"}}> Topic Name : {state?.topicName}</Typography></Grid>           
             <Grid item xs={12} height={100}> <PartitionGrid/>   </Grid>
        </Grid>
        </Fade >            
     );
}
export default PartitionContainer;
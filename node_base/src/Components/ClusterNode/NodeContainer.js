
import { Grid, Typography } from '@material-ui/core';
import React from 'react';
import NodeGrid from './NodeGrid';

const NodeContainer = ()=>{
    return (
       <Grid container direction="column">  
            <Grid item xs={12}><Typography variant="h5" style={{padding:"30px"}}> Cluster Node Details</Typography></Grid>          
            <Grid item xs={12} height={100}> <NodeGrid />   </Grid>
       </Grid>            
    );
}
export default NodeContainer;
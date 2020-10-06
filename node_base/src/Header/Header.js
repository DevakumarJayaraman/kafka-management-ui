import React from 'react';
import {AppBar, makeStyles, Toolbar, Typography,IconButton} from '@material-ui/core';
import HomeIcon from '@material-ui/icons/Home';

const useStyles = makeStyles(()=>({
    title:{
        flexGrow:1
    }
}));

const Header = ()=>{
    const classes = useStyles();
    return (
        <AppBar position="static">
            <Toolbar>
                <Typography className={classes.title} variant="h6">Kafka Management</Typography>                
                <IconButton>
                    <HomeIcon style={{color:"#fff"}}/>
                </IconButton>                
            </Toolbar>
        </AppBar>
    );
}
export default Header;
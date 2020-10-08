import React from 'react';
import {useHistory} from 'react-router-dom';
import {AppBar, makeStyles, Toolbar, Typography,IconButton} from '@material-ui/core';
import HomeIcon from '@material-ui/icons/Home';

const useStyles = makeStyles(()=>({
    title:{
        flexGrow:1
    }
}));

const Header = ()=>{
    const classes = useStyles();
    const history = useHistory();

    const goHome=()=>{
        history.push("/");
    }

    return (
        <AppBar position="static">
            <Toolbar>
                <Typography className={classes.title} variant="h6">Kafka Management</Typography>                
                <IconButton onClick={goHome}>
                    <HomeIcon style={{color:"#fff"}}/>
                </IconButton>                
            </Toolbar>
        </AppBar>
    );
}
export default Header;
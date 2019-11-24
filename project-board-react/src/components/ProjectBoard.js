import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import ProjectTaskItem from './ProjectTask/ProjectTaskItem';
import { connect } from "react-redux";
import PropTypes from 'prop-types';
import { getBacklog } from "../actions/projectTaskActions";

class ProjectBoard extends Component {

    componentDidMount() {
        //Right After Mount , get Lists.
        this.props.getBacklog();
    }

    render() {
        return (
            // <!-- Project Board Starts Here MIND OTHER COMPONENTS WHEN COPY AND PASTING -->
            <div className="container">
                <Link to="/addProjectTask" className="btn btn-primary mb-3">
                    <i className="fas fa-plus-circle"> Create Project Task</i>
                </Link>
                <br />
                <hr />
                {/* <!-- Backlog STARTS HERE --> */}
                <div className="container">
                    <div className="row">
                        <div className="col-md-4">
                            <div className="card text-center mb-2">
                                <div className="card-header bg-secondary text-white">
                                    <h3>TO DO</h3>
                                </div>
                            </div>

                            {/* <!-- SAMPLE PROJECT TASK STARTS HERE --> */}
                            <ProjectTaskItem />


                            {/* <!-- SAMPLE PROJECT TASK ENDS HERE --> */}
                        </div>
                        <div className="col-md-4">
                            <div className="card text-center mb-2">
                                <div className="card-header bg-primary text-white">
                                    <h3>In Progress</h3>
                                </div>
                            </div>
                            {/* <!-- SAMPLE PROJECT TASK STARTS HERE --> */}
                            <ProjectTaskItem />

                            {/* <!-- SAMPLE PROJECT TASK ENDS HERE --> */}
                        </div>
                        <div className="col-md-4">
                            <div className="card text-center mb-2">
                                <div className="card-header bg-success text-white">
                                    <h3>Done</h3>
                                </div>
                            </div>
                            {/* <!-- SAMPLE PROJECT TASK STARTS HERE --> */}

                            {/* <!-- SAMPLE PROJECT TASK ENDS HERE --> */}
                        </div>
                    </div>
                </div>

                {/* <!-- Backlog ENDS HERE --> */}
            </div>

            // <!-- PROJECT BOARD ENDS HERE -->
        )
    }
}
ProjectBoard.propTypes = {
    getBacklog: PropTypes.func.isRequired,
    project_tasks: PropTypes.object.isRequired
};


const mapStateToProps = state => ({
    project_tasks: state.project_task
})

export default connect(mapStateToProps, { getBacklog })(ProjectBoard);
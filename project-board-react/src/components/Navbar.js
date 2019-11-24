import React from 'react'

export default function Navbar() {
    return (
        // <!-- NavBar Component Code -->
        <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
            <div className="container">
                <a className="navbar-brand" href="/">
                    Project Task Tool
                </a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-nav">
                    <span className="navbar-toggler-icon" />
                </button>
            </div>
        </nav>
    )
}


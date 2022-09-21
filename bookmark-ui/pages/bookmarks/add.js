import React, { useState } from "react";
import { createBookmark } from "../../services/api";

const Add = () => {
    const [title, setTitle] = useState("");
    const [url, setUrl] = useState("");

    const [validTitle, setValidTitle] = useState(true);
    const [validUrl, setValidUrl] = useState(true);

    const [message, setMessage] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setValidTitle(true);
        setValidUrl(true);
        if (!title) {
            setValidTitle(false);
            return;
        }
        if (!url) {
            setValidUrl(false);
            return;
        }
        const payload = {
            title: title,
            url: url,
        };
        try {
            const response = await createBookmark(payload);
            console.log(response);
            setTitle("");
            setUrl("");
            setMessage({
                state: "success",
                info: "Bookmark saved successfully!",
            });
            setValidTitle(true);
            setValidUrl(true);
        } catch (error) {
            setMessage({ state: "danger", info: "Something went wrong!" });
        }
    };

    return (
        <div className="container">
            <div className="row mt-4">
                <div className="col-md-12">
                    <h1 className="text-center">Save Your Bookmark</h1>
                    <div className="row mt-5 justify-content-center">
                        <div className="col-md-6">
                            {message && (
                                <div
                                    className={"alert alert-" + message.state}
                                    role="alert"
                                >
                                    {message.info}
                                </div>
                            )}
                            <div className="card">
                                <div className="card-body">
                                    <form onSubmit={handleSubmit}>
                                        <div className="mb-3">
                                            <label
                                                htmlFor="title"
                                                className="form-label"
                                            >
                                                Title
                                            </label>
                                            <input
                                                type="text"
                                                className={
                                                    "form-control " +
                                                    (validTitle
                                                        ? ""
                                                        : "is-invalid")
                                                }
                                                id="title"
                                                name="title"
                                                value={title}
                                                onChange={(e) =>
                                                    setTitle(e.target.value)
                                                }
                                            />
                                            {!validTitle && (
                                                <div className="invalid-feedback">
                                                    Please enter a valid title.
                                                </div>
                                            )}
                                        </div>
                                        <div className="mb-3">
                                            <label
                                                htmlFor="url"
                                                className="form-label"
                                            >
                                                URL
                                            </label>
                                            <input
                                                type="text"
                                                className={
                                                    "form-control " +
                                                    (validUrl
                                                        ? ""
                                                        : "is-invalid")
                                                }
                                                id="url"
                                                name="url"
                                                value={url}
                                                onChange={(e) =>
                                                    setUrl(e.target.value)
                                                }
                                            />
                                            {!validUrl && (
                                                <div className="invalid-feedback">
                                                    Please enter a valid URL.
                                                </div>
                                            )}
                                        </div>
                                        <button
                                            type="submit"
                                            className="btn btn-primary"
                                        >
                                            Submit
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Add;

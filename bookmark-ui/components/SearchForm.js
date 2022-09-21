import React, { useState } from "react";
import { useRouter } from "next/router";

const SearchForm = () => {
    const router = useRouter();
    const [query, setQuery] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (query === "") {
            await router.push("/");
            return;
        }
        console.log(query);
        await router.push(`/bookmarks/search?query=${query}`);
    };

    return (
        <form onSubmit={handleSubmit}>
            <div className="row my-4 justify-content-center align-items-center">
                <div className="col-md-6">
                    <input
                        type="text"
                        name="query"
                        id="query"
                        className="form-control"
                        placeholder="Search Bookmark"
                        value={query}
                        onChange={(e) => setQuery(e.target.value)}
                    />
                </div>
                <div className="col-auto">
                    <button type="submit" className="btn btn-primary">
                        Search
                    </button>
                </div>
            </div>
        </form>
    );
};

export default SearchForm;

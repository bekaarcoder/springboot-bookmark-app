import Link from "next/link";

const Pagination = ({ bookmarks, query }) => {
    const path = query == undefined || query === "" ? "/" : "/bookmarks/search";
    const queryParams =
        query === undefined || query === "" ? {} : { query: query };
    const firstPage = { pathname: path, query: { page: 1, ...queryParams } };
    const previousPage = {
        pathname: path,
        query: { page: bookmarks.currentPage - 1, ...queryParams },
    };
    const nextPage = {
        pathname: path,
        query: { page: bookmarks.currentPage + 1, ...queryParams },
    };
    const lastPage = {
        pathname: path,
        query: { page: bookmarks.totalPages, ...queryParams },
    };
    console.log(bookmarks);
    return (
        <nav aria-label="Page navigation">
            <ul className="pagination justify-content-center">
                <li
                    className={
                        "page-item " + (bookmarks.hasPrevious ? "" : "disabled")
                    }
                >
                    <Link href={firstPage}>
                        <a className="page-link">First</a>
                    </Link>
                </li>
                <li
                    className={
                        "page-item " + (bookmarks.hasPrevious ? "" : "disabled")
                    }
                >
                    <Link href={previousPage}>
                        <a className="page-link">Previous</a>
                    </Link>
                </li>
                <li
                    className={
                        "page-item " + (bookmarks.hasNext ? "" : "disabled")
                    }
                >
                    <Link href={nextPage}>
                        <a className="page-link">Next</a>
                    </Link>
                </li>
                <li
                    className={
                        "page-item " + (bookmarks.hasNext ? "" : "disabled")
                    }
                >
                    <Link href={lastPage}>
                        <a className="page-link">Last</a>
                    </Link>
                </li>
            </ul>
        </nav>
    );
};

export default Pagination;

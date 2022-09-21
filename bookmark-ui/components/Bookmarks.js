import Bookmark from "./Bookmark";
import Pagination from "./Pagination";

const Bookmarks = ({ bookmarks, query }) => {
    return (
        <div className="my-4">
            {bookmarks.data.map((bookmark) => (
                <Bookmark bookmark={bookmark} key={bookmark.id} />
            ))}
            <Pagination bookmarks={bookmarks} query={query} />
        </div>
    );
};

export default Bookmarks;

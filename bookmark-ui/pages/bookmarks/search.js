import Bookmarks from "../../components/Bookmarks";
import SearchForm from "../../components/SearchForm";
import { searchBookmarks } from "../../services/api";

export default function Search({ bookmarks, query }) {
    return (
        <div className="container">
            <div className="row mt-4">
                <div className="col-md-12">
                    <h1 className="text-center">Your Searched Bookmarks</h1>
                    <SearchForm />
                    <Bookmarks bookmarks={bookmarks} query={query} />
                </div>
            </div>
        </div>
    );
}

export const getServerSideProps = async (context) => {
    const { page = 1, query = "" } = context.query;
    const bookmarks = await searchBookmarks(parseInt(page), String(query));
    return {
        props: {
            bookmarks: bookmarks,
            query: query,
        },
    };
};

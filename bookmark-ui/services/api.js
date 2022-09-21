import axios from "axios";
import getConfig from "next/config";

const { serverRuntimeConfig, publicRuntimeConfig } = getConfig();

// const API_BASE_URL = "http://localhost:8080";

const getApiUrl = () => {
    return (
        serverRuntimeConfig.API_BASE_URL ||
        publicRuntimeConfig.API_BASE_URL ||
        "http://localhost:8080"
    );
};

export const fetchBookmarks = async (page) => {
    console.log("serverRuntimeConfig: ", serverRuntimeConfig);
    console.log("publicRuntimeConfig: ", publicRuntimeConfig);
    const res = await axios.get(`${getApiUrl()}/api/bookmarks?page=${page}`);
    return res.data;
};

export const searchBookmarks = async (page, query) => {
    console.log("serverRuntimeConfig: ", serverRuntimeConfig);
    console.log("publicRuntimeConfig: ", publicRuntimeConfig);
    let url = `${getApiUrl()}/api/bookmarks?page=${page}`;
    if (query) {
        url += `&query=${query}`;
    }
    const res = await axios.get(url);
    return res.data;
};

export const createBookmark = async (payload) => {
    console.log("serverRuntimeConfig: ", serverRuntimeConfig);
    console.log("publicRuntimeConfig: ", publicRuntimeConfig);
    let url = `${getApiUrl()}/api/bookmarks`;
    const res = await axios.post(url, payload);
    return res.data;
};
